package com.demo.hotel.business.controller;


import com.demo.hotel.business.dto.TrainingDTO;
import com.demo.hotel.business.dto.TrainingEcDTO;
import com.demo.hotel.business.dto.param.TrainingParam;
import com.demo.hotel.commons.dto.CodeStatus;
import com.demo.hotel.commons.dto.ResponseResult;
import com.demo.hotel.provider.api.TrainingContentService;
import com.demo.hotel.provider.api.TrainingEcService;
import com.demo.hotel.provider.api.TrainingService;
import com.demo.hotel.provider.domain.Training;
import com.demo.hotel.provider.domain.TrainingEc;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: HotelERPManagementSystem
 * @description: 培训控制器
 * @author: syj
 * @create: 2020-04-07 08:00
 **/
@RequestMapping(value = "train/training")
@RestController
public class TrainingController {
    @Reference(version = "1.0.0")
    TrainingService trainingService;

    @Reference(version = "1.0.0")
    TrainingEcService trainingEcService;

    @Reference(version = "1.0.0")
    TrainingContentService trainingContentService;

    /**
     * 获取培训
     *
     * @return
     */
    @GetMapping(value = "info")
    public ResponseResult<List<TrainingEcDTO>> info() {
        List<TrainingEc> trainingEcs = trainingEcService.selectAll();

        List<TrainingEcDTO> trainingEcDTOS = new ArrayList<>();

        trainingEcs.forEach(trainingEc -> {
            TrainingEcDTO trainingEcDTO = new TrainingEcDTO();
            BeanUtils.copyProperties(trainingEc, trainingEcDTO);
            trainingEcDTOS.add(trainingEcDTO);
        });

        return new ResponseResult<>(CodeStatus.OK, "获取培训", trainingEcDTOS);
    }

    /**
     * 添加培训
     *
     * @param trainingParam
     * @return
     */
    @PostMapping(value = "add")
    public ResponseResult<Void> add(@RequestBody TrainingParam trainingParam) {

        Training training = new Training();
        BeanUtils.copyProperties(trainingParam, training);

        int sumTime = trainingContentService.searchByID(trainingParam.getTrainingContentId()).getSumTime().intValue();

        Date date = DateUtils.addDays(trainingParam.getCreateTime(), sumTime);
        training.setEndTime(date);


        int insert = trainingService.insert(training);
        if (insert > 0) {
            //添加培训成功
            return new ResponseResult<>(CodeStatus.OK, "添加培训成功");
        }
        //添加培训失败
        else {
            return new ResponseResult<>(CodeStatus.FAIL, "添加培训失败");
        }
    }


    /**
     * 删除
     *
     * @param id
     * @return
     */
    @PostMapping(value = "delete")
    public ResponseResult<Void> delete(@RequestBody Long id) {
        int delete = trainingService.delete(id);
        if (delete > 0) {
            //删除成功
            return new ResponseResult<>(CodeStatus.OK, "删除培训成功");
        }
        //删除失败
        else {
            return new ResponseResult<>(CodeStatus.FAIL, "删除培训失败");
        }
    }
}

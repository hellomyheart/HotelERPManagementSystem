package com.demo.hotel.business.controller;


import com.demo.hotel.business.base.controller.BaseTableController;
import com.demo.hotel.business.dto.TrainingDTO;
import com.demo.hotel.business.dto.TrainingEcDTO;
import com.demo.hotel.business.dto.param.TrainingParam;
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

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
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

    BaseTableController<TrainingService,TrainingEcService,TrainingDTO,TrainingEcDTO,Training,TrainingEc,TrainingParam> bt =new BaseTableController<>();
    /**
     * 获取培训
     *
     * @return
     */
    @GetMapping(value = "info")
    public ResponseResult<List<TrainingEcDTO>> info() {
        return bt.info(trainingEcService, new TrainingEcDTO());
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

        //培训开始时间改类型
        Instant instant = trainingParam.getCreateTime().toInstant();
        ZoneId zone = ZoneId.systemDefault();
        training.setCreateTime(LocalDateTime.ofInstant(instant,zone).toLocalDate());
        Date date = DateUtils.addDays(trainingParam.getCreateTime(), sumTime);

        //培训结束时间改类型
        Instant instant2 = date.toInstant();

        training.setEndTime(LocalDateTime.ofInstant(instant2, zone).toLocalDate());

        return bt.add(trainingService, training);
    }


    /**
     * 删除
     *
     * @param trainingDTO
     * @return
     */
    @PostMapping(value = "delete")
    public ResponseResult<Void> delete(@RequestBody TrainingDTO trainingDTO) {
        Long id = trainingDTO.getId();
        return bt.delete(trainingService, id);
    }
}

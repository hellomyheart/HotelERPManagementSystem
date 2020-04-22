package com.demo.hotel.business.controller;


import com.demo.hotel.business.dto.TrainingContentDTO;
import com.demo.hotel.business.dto.TrainingContentPDTO;
import com.demo.hotel.business.dto.param.TrainingContentParam;
import com.demo.hotel.commons.dto.CodeStatus;
import com.demo.hotel.commons.dto.ResponseResult;
import com.demo.hotel.provider.api.TrainingContentPService;
import com.demo.hotel.provider.api.TrainingContentService;
import com.demo.hotel.provider.domain.TrainingContent;
import com.demo.hotel.provider.domain.TrainingContentP;
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
 * @description: 培训内容控制器
 * @author: syj
 * @create: 2020-04-07 08:01
 **/
@RequestMapping(value = "train/content")
@RestController
public class TrainingContentController {

    @Reference(version = "1.0.0")
    TrainingContentService trainingContentService;

    @Reference(version = "1.0.0")
    TrainingContentPService trainingContentPService;

    /**
     * 获取培训内容
     *
     * @return
     */
    @GetMapping(value = "info")
    public ResponseResult<List<TrainingContentPDTO>> info() {
        List<TrainingContentP> trainingContentPS = trainingContentPService.selectAll();

        List<TrainingContentPDTO> trainingContentPDTOS = new ArrayList<>();

        trainingContentPS.forEach(trainingContentP -> {
            TrainingContentPDTO trainingContentPDTO = new TrainingContentPDTO();
            BeanUtils.copyProperties(trainingContentP, trainingContentPDTO);
            trainingContentPDTOS.add(trainingContentPDTO);
        });

        return new ResponseResult<>(CodeStatus.OK, "获取培训内容", trainingContentPDTOS);
    }

    /**
     * 添加培训内容
     *
     * @param trainingContentParam
     * @return
     */
    @PostMapping(value = "add")
    public ResponseResult<Void> add(@RequestBody TrainingContentParam trainingContentParam) {

        TrainingContent trainingContent = new TrainingContent();
        BeanUtils.copyProperties(trainingContentParam, trainingContent);
        trainingContent.setCreateTime(new Date());
        int insert = trainingContentService.insert(trainingContent);
        if (insert > 0) {
            //添加培训内容成功
            return new ResponseResult<>(CodeStatus.OK, "添加培训内容成功");
        }
        //添加培训内容失败
        else {
            return new ResponseResult<>(CodeStatus.FAIL, "添加培训内容失败");
        }
    }

    /**
     * 更新培训内容
     *
     * @param trainingContentDTO
     * @return
     */
    @PostMapping(value = "update")
    public ResponseResult<TrainingContentDTO> update(@RequestBody TrainingContentDTO trainingContentDTO) {
        TrainingContent trainingContent = new TrainingContent();
        BeanUtils.copyProperties(trainingContentDTO, trainingContent);
        trainingContent.setCreateTime(new Date());
        int update = trainingContentService.update(trainingContent);
        if (update > 0) {
            //更新培训内容成功
            return new ResponseResult<>(CodeStatus.OK, "更新培训内容成功", trainingContentDTO);
        }
        //更新失败
        else {
            return new ResponseResult<>(CodeStatus.FAIL, "更新失败");
        }
    }

    /**
     * 删除
     *
     * @param trainingContentDTO
     * @return
     */
    @PostMapping(value = "delete")
    public ResponseResult<Void> delete(@RequestBody TrainingContentDTO trainingContentDTO) {
        Long id = trainingContentDTO.getId();
        int delete = trainingContentService.delete(id);
        if (delete > 0) {
            //删除成功
            return new ResponseResult<>(CodeStatus.OK, "删除培训内容成功");
        }
        //删除失败
        else {
            return new ResponseResult<>(CodeStatus.FAIL, "删除培训内容失败");
        }
    }
}

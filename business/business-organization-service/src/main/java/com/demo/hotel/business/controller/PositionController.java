package com.demo.hotel.business.controller;

import com.demo.hotel.business.dto.PositionDDTO;
import com.demo.hotel.business.dto.PositionDTO;
import com.demo.hotel.business.dto.param.PositionParam;
import com.demo.hotel.commons.dto.CodeStatus;
import com.demo.hotel.commons.dto.ResponseResult;
import com.demo.hotel.provider.api.PositionDService;
import com.demo.hotel.provider.api.PositionService;
import com.demo.hotel.provider.domain.Position;
import com.demo.hotel.provider.domain.PositionD;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: HotelERPManagementSystem
 * @description: 职位控制器
 * @author: syj
 * @create: 2020-04-03 16:52
 **/
@RequestMapping(value = "position")
@RestController
public class PositionController {

    @Reference(version = "1.0.0")
    PositionService positionService;

    @Reference(version = "1.0.0")
    PositionDService positionDService;

    /**
     * 获取职位信息
     *
     * @return
     */
    @GetMapping(value = "info")
    public ResponseResult<List<PositionDDTO>> info() {
        List<PositionD> positionDS = positionDService.selectAll();

        List<PositionDDTO> positionDDTOS= new ArrayList<>();

        positionDS.forEach(positionD -> {
            PositionDDTO positionDDTO=new PositionDDTO();
            BeanUtils.copyProperties(positionD,positionDDTO);
            positionDDTOS.add(positionDDTO);
        });

        return new ResponseResult<>(CodeStatus.OK, "获取职位信息", positionDDTOS);
    }

    /**
     * 添加职位信息
     * @param positionParam
     * @return
     */
    @PostMapping(value = "add")
    public ResponseResult<Void> add(@RequestBody PositionParam positionParam){
        Position position=new Position();
        BeanUtils.copyProperties(positionParam,position);
        int result = positionService.insert(position);
        if (result>0){
            //添加职位成功
            return new ResponseResult<>(CodeStatus.OK, "职位添加成功");
        }
        //添加职位失败
        else
        {
            return new ResponseResult<>(CodeStatus.FAIL, "职位添加失败");
        }
    }

    /**
     * 更新职位信息
     * @param positionDTO
     * @return
     */
    @PostMapping(value = "update")
    public ResponseResult<PositionDTO> update(@RequestBody PositionDTO positionDTO){
        Position position=new Position();
        BeanUtils.copyProperties(positionDTO,position);
        int result = positionService.update(position);
        if (result>0){
            //更新职位成功
            return new ResponseResult<PositionDTO>(CodeStatus.OK, "更新职位成功", positionDTO);
        }
        //更新职位失败
        else {
            return new ResponseResult<>(CodeStatus.FAIL, "更新失败");
        }
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @PostMapping(value = "delete")
    public ResponseResult<Void> delete(@RequestBody Long id){
        int result = positionService.delete(id);
        if (result>0){
            //删除职位成功
            return new ResponseResult<>(CodeStatus.OK, "删除职位成功");
        }
        //删除失败
        else {
            return new ResponseResult<>(CodeStatus.FAIL, "删除职位失败");
        }
    }
}

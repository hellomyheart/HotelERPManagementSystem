package com.demo.hotel.business.controller;


import com.demo.hotel.business.dto.ShiftTypeDDTO;
import com.demo.hotel.business.dto.ShiftTypeDTO;
import com.demo.hotel.business.dto.param.ShiftTypeParam;
import com.demo.hotel.commons.dto.CodeStatus;
import com.demo.hotel.commons.dto.ResponseResult;
import com.demo.hotel.provider.api.ShiftTypeDService;
import com.demo.hotel.provider.api.ShiftTypeService;
import com.demo.hotel.provider.domain.ShiftType;
import com.demo.hotel.provider.domain.ShiftTypeD;
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
 * @description: 排班类型控制器
 * @author: syj
 * @create: 2020-04-07 08:01
 **/
@RequestMapping(value = "shift/type")
@RestController
public class ShiftTypeController {

    @Reference(version = "1.0.0")
    ShiftTypeService shiftTypeService;

    @Reference(version = "1.0.0")
    ShiftTypeDService shiftTypeDService;

    /**
     * 获取排班分类
     *
     * @return
     */
    @GetMapping(value = "info")
    public ResponseResult<List<ShiftTypeDDTO>> info() {
        List<ShiftTypeD> shiftTypeDS = shiftTypeDService.selectAll();

        List<ShiftTypeDDTO> shiftTypeDDTOS = new ArrayList<>();

        shiftTypeDS.forEach(shiftTypeD -> {
            ShiftTypeDDTO shiftTypeDDTO = new ShiftTypeDDTO();
            BeanUtils.copyProperties(shiftTypeD, shiftTypeDDTO);
            shiftTypeDDTOS.add(shiftTypeDDTO);
        });

        return new ResponseResult<>(CodeStatus.OK, "获取排班分类", shiftTypeDDTOS);
    }

    /**
     * 添加排班分类
     * @param shiftTypeParam
     * @return
     */
    @PostMapping(value = "add")
    public ResponseResult<Void> add(@RequestBody ShiftTypeParam shiftTypeParam) {

        ShiftType shiftType=new ShiftType();
        BeanUtils.copyProperties(shiftTypeParam,shiftType);

        int insert = shiftTypeService.insert(shiftType);
        if (insert > 0) {
            //添加排班分类
            return new ResponseResult<>(CodeStatus.OK, "添加排班分类成功");
        }
        //添加排班分类失败
        else {
            return new ResponseResult<>(CodeStatus.FAIL, "添加排班分类失败");
        }
    }

    /**
     * 更新排班分类
     * @param shiftTypeDTO
     * @return
     */
    @PostMapping(value = "update")
    public ResponseResult<ShiftTypeDTO> update(@RequestBody ShiftTypeDTO shiftTypeDTO) {
        ShiftType shiftType=new ShiftType();
        BeanUtils.copyProperties(shiftTypeDTO, shiftType);
        int update = shiftTypeService.update(shiftType);
        if (update > 0) {
            //更新排班分类成功
            return new ResponseResult<>(CodeStatus.OK, "更新排班分类成功", shiftTypeDTO);
        }
        //更新失败
        else {
            return new ResponseResult<>(CodeStatus.FAIL, "更新失败");
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
        int delete = shiftTypeService.delete(id);
        if (delete > 0) {
            //删除成功
            return new ResponseResult<>(CodeStatus.OK, "删除排班分类成功");
        }
        //删除失败
        else {
            return new ResponseResult<>(CodeStatus.FAIL, "删除排班分类失败");
        }
    }
}

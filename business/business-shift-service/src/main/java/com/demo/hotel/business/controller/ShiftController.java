package com.demo.hotel.business.controller;


import com.demo.hotel.business.dto.ShiftDTO;
import com.demo.hotel.business.dto.ShiftTDTO;
import com.demo.hotel.business.dto.param.ShiftParam;
import com.demo.hotel.commons.dto.CodeStatus;
import com.demo.hotel.commons.dto.ResponseResult;
import com.demo.hotel.provider.api.ShiftService;
import com.demo.hotel.provider.api.ShiftTService;
import com.demo.hotel.provider.domain.Shift;
import com.demo.hotel.provider.domain.ShiftT;
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
 * @description: 排班内容控制器
 * @author: syj
 * @create: 2020-04-07 08:01
 **/
@RequestMapping(value = "shift/content")
@RestController
public class ShiftController {

    @Reference(version = "1.0.0")
    ShiftService shiftService;

    @Reference(version = "1.0.0")
    ShiftTService shiftTService;
    /**
     * 获取排班内容
     *
     * @return
     */
    @GetMapping(value = "info")
    public ResponseResult<List<ShiftTDTO>> info() {
        List<ShiftT> shiftTS = shiftTService.selectAll();

        List<ShiftTDTO> shiftTDTOS = new ArrayList<>();

        shiftTS.forEach(shiftT -> {
            ShiftTDTO shiftTDTO = new ShiftTDTO();
            BeanUtils.copyProperties(shiftT, shiftTDTO);
            shiftTDTOS.add(shiftTDTO);
        });

        return new ResponseResult<>(CodeStatus.OK, "获取排班内容", shiftTDTOS);
    }

    /**
     * 添加排班内容
     * @param shiftParam
     * @return
     */
    @PostMapping(value = "add")
    public ResponseResult<Void> add(@RequestBody ShiftParam shiftParam) {

        Shift shift=new Shift();
        BeanUtils.copyProperties(shiftParam,shift);

        int insert = shiftService.insert(shift);
        if (insert > 0) {
            //添加排班
            return new ResponseResult<>(CodeStatus.OK, "添加排班成功");
        }
        //添加排班失败
        else {
            return new ResponseResult<>(CodeStatus.FAIL, "添加排班失败");
        }
    }

    /**
     * 更新排班
     * @param shiftDTO
     * @return
     */
    @PostMapping(value = "update")
    public ResponseResult<ShiftDTO> update(@RequestBody ShiftDTO shiftDTO) {
       Shift shift=new Shift();
        BeanUtils.copyProperties(shiftDTO, shift);
        int update = shiftService.update(shift);
        if (update > 0) {
            //更新排班成功
            return new ResponseResult<>(CodeStatus.OK, "更新排班分类成功", shiftDTO);
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
        int delete = shiftService.delete(id);
        if (delete > 0) {
            //删除成功
            return new ResponseResult<>(CodeStatus.OK, "删除排班成功");
        }
        //删除失败
        else {
            return new ResponseResult<>(CodeStatus.FAIL, "删除排班失败");
        }
    }
}

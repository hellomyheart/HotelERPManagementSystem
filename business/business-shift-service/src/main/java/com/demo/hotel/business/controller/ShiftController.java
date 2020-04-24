package com.demo.hotel.business.controller;


import com.demo.hotel.business.base.controller.BaseTableController;
import com.demo.hotel.business.dto.ShiftDTO;
import com.demo.hotel.business.dto.ShiftTDTO;
import com.demo.hotel.business.dto.param.ShiftParam;
import com.demo.hotel.commons.dto.ResponseResult;
import com.demo.hotel.provider.api.ShiftService;
import com.demo.hotel.provider.api.ShiftTService;
import com.demo.hotel.provider.domain.Shift;
import com.demo.hotel.provider.domain.ShiftT;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    BaseTableController<ShiftService,ShiftTService,ShiftDTO,ShiftTDTO,Shift,ShiftT,ShiftParam> bt =new BaseTableController<>();

    /**
     * 获取排班内容
     *
     * @return
     */
    @GetMapping(value = "info")
    public ResponseResult<List<ShiftTDTO>> info() {
        return bt.info(shiftTService, new ShiftTDTO());
    }

    /**
     * 添加排班内容
     *
     * @param shiftParam
     * @return
     */
    @PostMapping(value = "add")
    public ResponseResult<Void> add(@RequestBody ShiftParam shiftParam) {

        Shift shift = new Shift();
        return bt.add(shiftService, shift, shiftParam);
    }

    /**
     * 更新排班
     *
     * @param shiftDTO
     * @return
     */
    @PostMapping(value = "update")
    public ResponseResult<Void> update(@RequestBody ShiftDTO shiftDTO) {
        Shift shift = new Shift();
        return bt.update(shiftService, shift, shiftDTO);
    }

    /**
     * 删除
     *
     * @param shiftDTO
     * @return
     */
    @PostMapping(value = "delete")
    public ResponseResult<Void> delete(@RequestBody ShiftDTO shiftDTO) {
        Long id = shiftDTO.getId();
        return bt.delete(shiftService, id);
    }
}

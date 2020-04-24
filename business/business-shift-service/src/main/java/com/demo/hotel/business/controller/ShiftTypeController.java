package com.demo.hotel.business.controller;


import com.demo.hotel.business.base.controller.BaseController;
import com.demo.hotel.business.base.controller.BaseTableController;
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
    BaseTableController<ShiftTypeService, ShiftTypeDService, ShiftTypeDTO, ShiftTypeDDTO, ShiftType, ShiftTypeD, ShiftTypeParam> bt = new BaseTableController<>();

    /**
     * 获取排班分类
     *
     * @return
     */
    @GetMapping(value = "info")
    public ResponseResult<List<ShiftTypeDDTO>> info() {
        return bt.info(shiftTypeDService, new ShiftTypeDDTO());
    }

    /**
     * 添加排班分类
     *
     * @param shiftTypeParam
     * @return
     */
    @PostMapping(value = "add")
    public ResponseResult<Void> add(@RequestBody ShiftTypeParam shiftTypeParam) {

        ShiftType shiftType = new ShiftType();
        return bt.add(shiftTypeService, shiftType, shiftTypeParam);
    }

    /**
     * 更新排班分类
     *
     * @param shiftTypeDTO
     * @return
     */
    @PostMapping(value = "update")
    public ResponseResult<Void> update(@RequestBody ShiftTypeDTO shiftTypeDTO) {
        ShiftType shiftType = new ShiftType();
        return bt.update(shiftTypeService, shiftType, shiftTypeDTO);
    }

    /**
     * 删除
     *
     * @param shiftTypeDTO
     * @return
     */
    @PostMapping(value = "delete")
    public ResponseResult<Void> delete(@RequestBody ShiftTypeDTO shiftTypeDTO) {
        Long id = shiftTypeDTO.getId();
        return bt.delete(shiftTypeService, id);
    }
}

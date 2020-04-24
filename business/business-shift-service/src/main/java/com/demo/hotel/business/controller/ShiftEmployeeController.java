package com.demo.hotel.business.controller;


import com.demo.hotel.business.base.controller.BaseTableController;
import com.demo.hotel.business.dto.ShiftEmployeeDTO;
import com.demo.hotel.business.dto.ShiftEmployeeEDTO;
import com.demo.hotel.business.dto.param.ShiftEmployeeParam;
import com.demo.hotel.commons.dto.ResponseResult;
import com.demo.hotel.provider.api.ShiftEmployeeEService;
import com.demo.hotel.provider.api.ShiftEmployeeService;
import com.demo.hotel.provider.domain.ShiftEmployee;
import com.demo.hotel.provider.domain.ShiftEmployeeE;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: HotelERPManagementSystem
 * @description: 排班职工控制器
 * @author: syj
 * @create: 2020-04-07 08:01
 **/
@RequestMapping(value = "shift/employee")
@RestController
public class ShiftEmployeeController {

    @Reference(version = "1.0.0")
    ShiftEmployeeService shiftEmployeeService;

    @Reference(version = "1.0.0")
    ShiftEmployeeEService shiftEmployeeEService;

    BaseTableController<ShiftEmployeeService,ShiftEmployeeEService,ShiftEmployeeDTO,ShiftEmployeeEDTO,ShiftEmployee,ShiftEmployeeE,ShiftEmployeeParam> bt=new BaseTableController<>();
    /**
     * 获取职位排班
     *
     * @return
     */
    @GetMapping(value = "info")
    public ResponseResult<List<ShiftEmployeeEDTO>> info() {
        return bt.info(shiftEmployeeEService, new ShiftEmployeeEDTO());
    }

    /**
     * 添加职位排班
     * @param shiftEmployeeParam
     * @return
     */
    @PostMapping(value = "add")
    public ResponseResult<Void> add(@RequestBody ShiftEmployeeParam shiftEmployeeParam) {

        ShiftEmployee shiftEmployee=new ShiftEmployee();
        return bt.add(shiftEmployeeService, shiftEmployee, shiftEmployeeParam);
    }

    /**
     * 更新排班分类
     * @param shiftEmployeeDTO
     * @return
     */
    @PostMapping(value = "update")
    public ResponseResult<Void> update(@RequestBody ShiftEmployeeDTO shiftEmployeeDTO) {
        ShiftEmployee shiftEmployee=new ShiftEmployee();
        return bt.update(shiftEmployeeService, shiftEmployee, shiftEmployeeDTO);
    }

    /**
     * 删除
     * @param shiftEmployeeDTO
     * @return
     */
    @PostMapping(value = "delete")
    public ResponseResult<Void> delete(@RequestBody ShiftEmployeeDTO shiftEmployeeDTO) {
        Long id = shiftEmployeeDTO.getId();
        return bt.delete(shiftEmployeeService, id);
    }
}

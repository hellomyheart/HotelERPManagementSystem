package com.demo.hotel.business.controller;


import com.demo.hotel.business.dto.ShiftEmployeeDTO;
import com.demo.hotel.business.dto.ShiftEmployeeEDTO;
import com.demo.hotel.business.dto.param.ShiftEmployeeParam;
import com.demo.hotel.commons.dto.CodeStatus;
import com.demo.hotel.commons.dto.ResponseResult;
import com.demo.hotel.provider.api.ShiftEmployeeEService;
import com.demo.hotel.provider.api.ShiftEmployeeService;
import com.demo.hotel.provider.domain.ShiftEmployee;
import com.demo.hotel.provider.domain.ShiftEmployeeE;
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

    /**
     * 获取职位排班
     *
     * @return
     */
    @GetMapping(value = "info")
    public ResponseResult<List<ShiftEmployeeEDTO>> info() {
        List<ShiftEmployeeE> shiftEmployeeES = shiftEmployeeEService.selectAll();

        List<ShiftEmployeeEDTO> shiftEmployeeEDTOS = new ArrayList<>();

        shiftEmployeeES.forEach(shiftEmployeeE -> {
            ShiftEmployeeEDTO shiftEmployeeEDTO = new ShiftEmployeeEDTO();
            BeanUtils.copyProperties(shiftEmployeeE, shiftEmployeeEDTO);
            shiftEmployeeEDTOS.add(shiftEmployeeEDTO);
        });

        return new ResponseResult<>(CodeStatus.OK, "获取职位排班", shiftEmployeeEDTOS);
    }

    /**
     * 添加职位排班
     * @param shiftEmployeeParam
     * @return
     */
    @PostMapping(value = "add")
    public ResponseResult<Void> add(@RequestBody ShiftEmployeeParam shiftEmployeeParam) {

        ShiftEmployee shiftEmployee=new ShiftEmployee();
        BeanUtils.copyProperties(shiftEmployeeParam,shiftEmployee);

        int insert = shiftEmployeeService.insert(shiftEmployee);
        if (insert > 0) {
            //添加职工排班成功
            return new ResponseResult<>(CodeStatus.OK, "添加职工排班成功");
        }
        //添加职工排班失败
        else {
            return new ResponseResult<>(CodeStatus.FAIL, "添加职工排班失败");
        }
    }

    /**
     * 更新排班分类
     * @param shiftEmployeeDTO
     * @return
     */
    @PostMapping(value = "update")
    public ResponseResult<ShiftEmployeeDTO> update(@RequestBody ShiftEmployeeDTO shiftEmployeeDTO) {
        ShiftEmployee shiftEmployee=new ShiftEmployee();
        BeanUtils.copyProperties(shiftEmployeeDTO, shiftEmployee);
        int update = shiftEmployeeService.update(shiftEmployee);
        if (update > 0) {
            //更新职工排班成功
            return new ResponseResult<>(CodeStatus.OK, "更新职工排班成功", shiftEmployeeDTO);
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
        int delete = shiftEmployeeService.delete(id);
        if (delete>0){
        //删除成功
            return new ResponseResult<>(CodeStatus.OK, "删除职工排班成功");
        }
        //删除失败
        else {
            return new ResponseResult<>(CodeStatus.FAIL, "删除职工排班失败");
        }
    }
}

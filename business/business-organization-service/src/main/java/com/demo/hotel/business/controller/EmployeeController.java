package com.demo.hotel.business.controller;

import com.demo.hotel.business.base.controller.BaseTableController;
import com.demo.hotel.business.dto.EmployeeDTO;
import com.demo.hotel.business.dto.EmployeePDTO;
import com.demo.hotel.business.dto.param.EmployeeParam;
import com.demo.hotel.commons.dto.ResponseResult;
import com.demo.hotel.provider.api.EmployeePService;
import com.demo.hotel.provider.api.EmployeeService;
import com.demo.hotel.provider.domain.Employee;
import com.demo.hotel.provider.domain.EmployeeP;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @program: HotelERPManagementSystem
 * @description: 职工控制器
 * @author: syj
 * @create: 2020-04-03 16:52
 **/
@RequestMapping(value = "organization/employee")
@RestController
public class EmployeeController {

    @Reference(version = "1.0.0")
    EmployeeService employeeService;

    @Reference(version = "1.0.0")
    EmployeePService employeePService;

    BaseTableController<EmployeeService,EmployeePService,EmployeeDTO,EmployeePDTO,Employee,EmployeeP,EmployeeParam> bt=new BaseTableController<>();

    /**
     * 获取职工信息
     *
     * @return
     */
    @GetMapping(value = "info")
    public ResponseResult<List<EmployeePDTO>> info() {
        return bt.info(employeePService, new EmployeePDTO());
    }

    /**
     * 添加职工信息
     *
     * @param employeeParam
     * @return
     */
    @PostMapping(value = "add")
    public ResponseResult<Void> add(@RequestBody EmployeeParam employeeParam) {


        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeParam, employee);
        employee.setCreateTime(new Date());
        employee.setUpdateTime(new Date());
        return bt.add(employeeService, employee);
    }

    /**
     * 更新职工信息
     *
     * @param employeeDTO
     * @return
     */
    @PostMapping(value = "update")
    public ResponseResult<Void> update(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);
        employee.setUpdateTime(new Date());
        return bt.update(employeeService, employee);
    }

    /**
     * 删除
     *
     * @param employeeDTO
     * @return
     */
    @PostMapping(value = "delete")
    public ResponseResult<Void> delete(@RequestBody EmployeeDTO employeeDTO) {
        Long id = employeeDTO.getId();
        return bt.delete(employeeService,id);
    }
}

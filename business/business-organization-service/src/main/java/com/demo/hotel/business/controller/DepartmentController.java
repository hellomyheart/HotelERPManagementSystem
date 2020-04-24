package com.demo.hotel.business.controller;

import com.demo.hotel.business.base.controller.BaseSingleTableController;
import com.demo.hotel.business.dto.DepartmentDTO;
import com.demo.hotel.business.dto.param.DepartmentParam;
import com.demo.hotel.commons.dto.ResponseResult;
import com.demo.hotel.provider.api.DepartmentService;
import com.demo.hotel.provider.domain.Department;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: HotelERPManagementSystem
 * @description: 部门控制器
 * @author: syj
 * @create: 2020-04-03 16:52
 **/
@RequestMapping(value = "organization/department")
@RestController
public class DepartmentController {

    @Reference(version = "1.0.0")
    DepartmentService departmentService;

    BaseSingleTableController<DepartmentService,DepartmentDTO,Department,DepartmentParam> bs=new BaseSingleTableController<>();
    /**
     * 获取部门信息
     *
     * @return
     */
    @GetMapping(value = "info")
    public ResponseResult<List<DepartmentDTO>> info() {
        return bs.info(departmentService, new DepartmentDTO());
    }

    /**
     * 添加部门信息
     * @param departmentParam
     * @return
     */
    @PostMapping(value = "add")
    public ResponseResult<Void> add(@RequestBody DepartmentParam departmentParam){


        Department department=new Department();
        return bs.add(departmentService, department, departmentParam);
    }

    /**
     * 更新部门信息
     * @param departmentDTO
     * @return
     */
    @PostMapping(value = "update")
    public ResponseResult<Void> update(@RequestBody DepartmentDTO departmentDTO){
        Department department =new Department();
        return bs.update(departmentService, department, departmentDTO);
    }

    /**
     * 删除部门信息
     * @param departmentDTO
     * @return
     */
    @PostMapping(value = "delete")
    public ResponseResult<Void> delete(@RequestBody DepartmentDTO departmentDTO){
        Long id = departmentDTO.getId();
        return bs.delete(departmentService, id);
    }
}

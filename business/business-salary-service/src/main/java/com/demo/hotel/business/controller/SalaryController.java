package com.demo.hotel.business.controller;

import com.demo.hotel.business.base.controller.BaseTableController;
import com.demo.hotel.business.dto.SalaryDTO;
import com.demo.hotel.business.dto.SalaryEDTO;
import com.demo.hotel.business.dto.param.SalaryParam;
import com.demo.hotel.commons.dto.ResponseResult;
import com.demo.hotel.provider.api.SalaryEService;
import com.demo.hotel.provider.api.SalaryService;
import com.demo.hotel.provider.domain.Salary;
import com.demo.hotel.provider.domain.SalaryE;
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
@RequestMapping(value = "salary")
@RestController
public class SalaryController {

    @Reference(version = "1.0.0")
    SalaryService service;

    @Reference(version = "1.0.0")
    SalaryEService vService;

    BaseTableController<SalaryService, SalaryEService, SalaryDTO, SalaryEDTO, Salary, SalaryE, SalaryParam> bt = new BaseTableController<>();

    /**
     * 获取信息
     *
     * @return
     */
    @GetMapping(value = "info")
    public ResponseResult<List<SalaryEDTO>> info() {
        return bt.info(vService, new SalaryEDTO());
    }

    /**
     * 添加信息
     *
     * @param param
     * @return
     */
    @PostMapping(value = "add")
    public ResponseResult<Void> add(@RequestBody SalaryParam param) {

        Salary domain =new Salary();
        System.out.println(param);

        BeanUtils.copyProperties(param, domain);
        domain.setCreatDate(new Date());
        return bt.add(service, domain);
    }

    //没有更新

    /**
     * 删除
     *
     * @param dTO
     * @return
     */
    @PostMapping(value = "delete")
    public ResponseResult<Void> delete(@RequestBody SalaryDTO dTO) {
        Long id = dTO.getId();
        return bt.delete(service, id);
    }
}

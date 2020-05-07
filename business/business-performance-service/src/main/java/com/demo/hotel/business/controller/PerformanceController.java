package com.demo.hotel.business.controller;

import com.demo.hotel.business.base.controller.BaseTableController;
import com.demo.hotel.business.dto.PerformanceDTO;
import com.demo.hotel.business.dto.PerformanceEDTO;
import com.demo.hotel.business.dto.param.PerformanceParam;
import com.demo.hotel.commons.dto.ResponseResult;
import com.demo.hotel.provider.api.PerformanceEService;
import com.demo.hotel.provider.api.PerformanceService;
import com.demo.hotel.provider.domain.Performance;
import com.demo.hotel.provider.domain.PerformanceE;
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
 * @description: 控制器
 * @author: syj
 * @create: 2020-04-03 16:52
 **/
@RequestMapping(value = "performance")
@RestController
public class PerformanceController {

    @Reference(version = "1.0.0")
    PerformanceService performanceService;

    @Reference(version = "1.0.0")
    PerformanceEService performanceEService;

    BaseTableController<PerformanceService, PerformanceEService, PerformanceDTO, PerformanceEDTO, Performance, PerformanceE, PerformanceParam> bt = new BaseTableController<>();

    /**
     * 获取信息
     *
     * @return
     */
    @GetMapping(value = "info")
    public ResponseResult<List<PerformanceEDTO>> info() {
        return bt.info(performanceEService, new PerformanceEDTO());
    }

    /**
     * 添加信息
     *
     * @param param
     * @return
     */
    @PostMapping(value = "add")
    public ResponseResult<Void> add(@RequestBody PerformanceParam param) {

        Performance performance = new Performance();
        BeanUtils.copyProperties(param, performance);
        performance.setCreatTime(new Date());
        return bt.add(performanceService, performance);
    }

    //没有修改

    /**
     * 删除
     *
     * @param dTO
     * @return
     */
    @PostMapping(value = "delete")
    public ResponseResult<Void> delete(@RequestBody PerformanceDTO dTO) {
        Long id = dTO.getId();
        return bt.delete(performanceService, id);
    }
}

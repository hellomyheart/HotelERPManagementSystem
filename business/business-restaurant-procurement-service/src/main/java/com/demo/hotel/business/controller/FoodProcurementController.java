package com.demo.hotel.business.controller;

import com.demo.hotel.business.base.controller.BaseTableController;
import com.demo.hotel.business.dto.FoodProcurementBfDTO;
import com.demo.hotel.business.dto.FoodProcurementDTO;
import com.demo.hotel.business.dto.param.FoodProcurementParam;
import com.demo.hotel.commons.dto.ResponseResult;
import com.demo.hotel.provider.api.FoodProcurementBfService;
import com.demo.hotel.provider.api.FoodProcurementService;
import com.demo.hotel.provider.domain.FoodProcurement;
import com.demo.hotel.provider.domain.FoodProcurementBf;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

/**
 * @program: HotelERPManagementSystem
 * @description: 控制器
 * @author: syj
 * @create: 2020-04-03 16:52
 **/
@RequestMapping(value = "restaurantProcurement/procurement")
@RestController
public class FoodProcurementController {

    @Reference(version = "1.0.0")
    FoodProcurementService service;

    @Reference(version = "1.0.0")
    FoodProcurementBfService vService;

    BaseTableController<FoodProcurementService, FoodProcurementBfService, FoodProcurementDTO, FoodProcurementBfDTO, FoodProcurement, FoodProcurementBf, FoodProcurementParam> bt = new BaseTableController<>();

    /**
     * 获取
     *
     * @return
     */
    @GetMapping(value = "info")
    public ResponseResult<List<FoodProcurementBfDTO>> info() {
        return bt.info(vService, new FoodProcurementBfDTO());
    }

    /**
     * 添加
     *
     * @param param
     * @return
     */
    @PostMapping(value = "add")
    public ResponseResult<Void> add(@RequestBody FoodProcurementParam param) {
        FoodProcurement foodProcurement = new FoodProcurement();
        BeanUtils.copyProperties(param, foodProcurement);
        foodProcurement.setCreatTime(LocalDate.now());
        return bt.add(service, foodProcurement);
    }

    /**
     * 更新
     *
     * @param dTO
     * @return
     */
    @PostMapping(value = "update")
    public ResponseResult<Void> update(@RequestBody FoodProcurementDTO dTO) {

        return bt.update(service, new FoodProcurement(), dTO);
    }

    /**
     * 删除
     *
     * @param dTO
     * @return
     */
    @PostMapping(value = "delete")
    public ResponseResult<Void> delete(@RequestBody FoodProcurementDTO dTO) {
        Long id = dTO.getId();
        return bt.delete(service, id);
    }
}

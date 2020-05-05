package com.demo.hotel.business.controller;

import com.demo.hotel.business.base.controller.BaseTableController;
import com.demo.hotel.business.dto.FoodDTO;
import com.demo.hotel.business.dto.FoodTDTO;
import com.demo.hotel.business.dto.param.FoodParam;
import com.demo.hotel.commons.dto.ResponseResult;
import com.demo.hotel.provider.api.FoodPService;
import com.demo.hotel.provider.api.FoodTService;
import com.demo.hotel.provider.domain.Food;
import com.demo.hotel.provider.domain.FoodT;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: HotelERPManagementSystem
 * @description: 控制器
 * @author: syj
 * @create: 2020-04-03 16:52
 **/
@RequestMapping(value = "restaurantProcurement/goods")
@RestController
public class FoodController {

    @Reference(version = "1.0.0")
    FoodPService service;

    @Reference(version = "1.0.0")
    FoodTService vService;

    BaseTableController<FoodPService, FoodTService, FoodDTO, FoodTDTO, Food, FoodT, FoodParam> bt = new BaseTableController<>();

    /**
     * 获取
     *
     * @return
     */
    @GetMapping(value = "info")
    public ResponseResult<List<FoodTDTO>> info() {
        return bt.info(vService, new FoodTDTO());
    }

    /**
     * 添加
     *
     * @param param
     * @return
     */
    @PostMapping(value = "add")
    public ResponseResult<Void> add(@RequestBody FoodParam param) {
        return bt.add(service, new Food(), param);
    }

    /**
     * 更新
     *
     * @param dTO
     * @return
     */
    @PostMapping(value = "update")
    public ResponseResult<Void> update(@RequestBody FoodDTO dTO) {
        return bt.update(service, new Food(), dTO);
    }

    /**
     * 删除
     *
     * @param dTO
     * @return
     */
    @PostMapping(value = "delete")
    public ResponseResult<Void> delete(@RequestBody FoodDTO dTO) {
        Long id = dTO.getId();
        return bt.delete(service, id);
    }
}

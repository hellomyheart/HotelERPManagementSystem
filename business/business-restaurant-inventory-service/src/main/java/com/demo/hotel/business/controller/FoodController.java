package com.demo.hotel.business.controller;

import com.demo.hotel.business.base.controller.BaseSingleTableController;
import com.demo.hotel.business.dto.FoodDTO;
import com.demo.hotel.business.dto.param.NullParam;
import com.demo.hotel.commons.dto.ResponseResult;
import com.demo.hotel.provider.api.FoodService;
import com.demo.hotel.provider.domain.Food;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: HotelERPManagementSystem
 * @description:
 * @author: syj
 * @create: 2020-04-03 16:52
 **/
@RequestMapping(value = "restaurant/inventory")
@RestController
public class FoodController {

    @Reference(version = "1.0.0")
    FoodService foodService;

    BaseSingleTableController<FoodService, FoodDTO, Food, NullParam> bs = new BaseSingleTableController<>();

    /**
     * 获取信息
     *
     * @return
     */
    @GetMapping(value = "info")
    public ResponseResult<List<FoodDTO>> info() {
        return bs.info(foodService, new FoodDTO());
    }


    /**
     * 更新信息
     *
     * @param dTO
     * @return
     */
    @PostMapping(value = "update")
    public ResponseResult<Void> update(@RequestBody FoodDTO dTO) {
        Food food=new Food();
        return bs.update(foodService, food, dTO);
    }
}

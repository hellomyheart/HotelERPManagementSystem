package com.demo.hotel.business.controller;

import com.demo.hotel.business.base.controller.BaseSingleTableController;
import com.demo.hotel.business.dto.FoodBuyerDTO;
import com.demo.hotel.business.dto.param.FoodBuyerParam;
import com.demo.hotel.commons.dto.ResponseResult;
import com.demo.hotel.provider.api.FoodBuyerService;
import com.demo.hotel.provider.domain.FoodBuyer;
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
@RequestMapping(value = "restaurantProcurement/buyer")
@RestController
public class FoodBuyerController {

    @Reference(version = "1.0.0")
    FoodBuyerService foodBuyerService;

    BaseSingleTableController<FoodBuyerService, FoodBuyerDTO, FoodBuyer, FoodBuyerParam> bs = new BaseSingleTableController<>();

    /**
     * 获取信息
     *
     * @return
     */
    @GetMapping(value = "info")
    public ResponseResult<List<FoodBuyerDTO>> info() {
        return bs.info(foodBuyerService, new FoodBuyerDTO());
    }

    /**
     * 添加
     * @param param
     * @return
     */
    @PostMapping(value = "add")
    public ResponseResult<Void> add(@RequestBody FoodBuyerParam param) {
        return bs.add(foodBuyerService, new FoodBuyer(), param);
    }

    /**
     * 更新
     * @param dTO
     * @return
     */
    @PostMapping(value = "update")
    public ResponseResult<Void> update(@RequestBody FoodBuyerDTO dTO) {
        return bs.update(foodBuyerService, new FoodBuyer(), dTO);
    }

    /**
     * 删除
     * @param dTO
     * @return
     */
    @PostMapping(value = "delete")
    public ResponseResult<Void> delete(@RequestBody FoodBuyerDTO dTO) {
        Long id = dTO.getId();
        return bs.delete(foodBuyerService, id);
    }
}

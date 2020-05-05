package com.demo.hotel.business.controller;

import com.demo.hotel.business.base.controller.BaseSingleTableController;
import com.demo.hotel.business.dto.FoodTypeDTO;
import com.demo.hotel.business.dto.param.FoodTypeParam;
import com.demo.hotel.commons.dto.ResponseResult;
import com.demo.hotel.provider.api.FoodTypeService;
import com.demo.hotel.provider.domain.FoodType;
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
@RequestMapping(value = "restaurantProcurement/type")
@RestController
public class FoodTypeController {

    @Reference(version = "1.0.0")
    FoodTypeService service;

    BaseSingleTableController<FoodTypeService, FoodTypeDTO, FoodType, FoodTypeParam> bs=new BaseSingleTableController<>();
    /**
     * 获取信息
     *
     * @return
     */
    @GetMapping(value = "info")
    public ResponseResult<List<FoodTypeDTO>> info() {
        return bs.info(service, new FoodTypeDTO());
    }

    /**
     * 添加
     * @param param
     * @return
     */
    @PostMapping(value = "add")
    public ResponseResult<Void> add(@RequestBody FoodTypeParam param){
        return bs.add(service, new FoodType(), param);
    }

    /**
     * 更新
     * @param dTO
     * @return
     */
    @PostMapping(value = "update")
    public ResponseResult<Void> update(@RequestBody FoodTypeDTO dTO){
        return bs.update(service, new FoodType(), dTO);
    }

    /**
     * 删除
     * @param dTO
     * @return
     */
    @PostMapping(value = "delete")
    public ResponseResult<Void> delete(@RequestBody FoodTypeDTO dTO){
        Long id = dTO.getId();
        return bs.delete(service, id);
    }
}

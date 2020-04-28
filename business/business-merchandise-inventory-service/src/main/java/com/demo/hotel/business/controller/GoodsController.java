package com.demo.hotel.business.controller;

import com.demo.hotel.business.base.controller.BaseSingleTableController;
import com.demo.hotel.business.dto.GoodsDTO;
import com.demo.hotel.business.dto.param.NullParam;
import com.demo.hotel.commons.dto.ResponseResult;
import com.demo.hotel.provider.api.GoodsService;
import com.demo.hotel.provider.domain.Goods;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: HotelERPManagementSystem
 * @description: 部门控制器
 * @author: syj
 * @create: 2020-04-03 16:52
 **/
@RequestMapping(value = "merchandise/inventory")
@RestController
public class GoodsController {

    @Reference(version = "1.0.0")
    GoodsService goodsService;

    BaseSingleTableController<GoodsService, GoodsDTO, Goods, NullParam> bs=new BaseSingleTableController<>();
    /**
     * 获取信息
     *
     * @return
     */
    @GetMapping(value = "info")
    public ResponseResult<List<GoodsDTO>> info() {
        return bs.info(goodsService, new GoodsDTO());
    }


    /**
     * 更新信息
     * @param dTO
     * @return
     */
    @PostMapping(value = "update")
    public ResponseResult<Void> update(@RequestBody GoodsDTO dTO){
        Goods goods=new Goods();
        return bs.update(goodsService, goods, dTO);
    }
}

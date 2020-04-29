package com.demo.hotel.business.controller;

import com.demo.hotel.business.base.controller.BaseTableController;
import com.demo.hotel.business.dto.GoodsDTO;
import com.demo.hotel.business.dto.GoodsTDTO;
import com.demo.hotel.business.dto.param.GoodsParam;
import com.demo.hotel.commons.dto.ResponseResult;
import com.demo.hotel.provider.api.GoodsPService;
import com.demo.hotel.provider.api.GoodsTService;
import com.demo.hotel.provider.domain.Goods;
import com.demo.hotel.provider.domain.GoodsT;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: HotelERPManagementSystem
 * @description: 职工控制器
 * @author: syj
 * @create: 2020-04-03 16:52
 **/
@RequestMapping(value = "merchandiseProcurement/goods")
@RestController
public class GoodsController {

    @Reference(version = "1.0.0")
    GoodsPService goodsService;

    @Reference(version = "1.0.0")
    GoodsTService goodsTService;

    BaseTableController<GoodsPService, GoodsTService, GoodsDTO, GoodsTDTO, Goods, GoodsT, GoodsParam> bt = new BaseTableController<>();

    /**
     * 获取
     *
     * @return
     */
    @GetMapping(value = "info")
    public ResponseResult<List<GoodsTDTO>> info() {
        return bt.info(goodsTService, new GoodsTDTO());
    }

    /**
     * 添加
     *
     * @param goodsParam
     * @return
     */
    @PostMapping(value = "add")
    public ResponseResult<Void> add(@RequestBody GoodsParam goodsParam) {
        Goods goods = new Goods();
        return bt.add(goodsService, goods, goodsParam);
    }

    /**
     * 更新
     *
     * @param goodsDTO
     * @return
     */
    @PostMapping(value = "update")
    public ResponseResult<Void> update(@RequestBody GoodsDTO goodsDTO) {
        Goods goods = new Goods();
        return bt.update(goodsService, goods, goodsDTO);
    }

    /**
     * 删除
     *
     * @param goodsDTO
     * @return
     */
    @PostMapping(value = "delete")
    public ResponseResult<Void> delete(@RequestBody GoodsDTO goodsDTO) {
        Long id = goodsDTO.getId();
        return bt.delete(goodsService, id);
    }
}

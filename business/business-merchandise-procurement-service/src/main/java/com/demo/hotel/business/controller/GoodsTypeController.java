package com.demo.hotel.business.controller;

import com.demo.hotel.business.base.controller.BaseSingleTableController;
import com.demo.hotel.business.dto.GoodsTypeDTO;
import com.demo.hotel.business.dto.param.GoodsTypeParam;
import com.demo.hotel.commons.dto.ResponseResult;
import com.demo.hotel.provider.api.GoodsTypeService;
import com.demo.hotel.provider.domain.GoodsType;
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
 * @description: 控制器
 * @author: syj
 * @create: 2020-04-03 16:52
 **/
@RequestMapping(value = "merchandiseProcurement/type")
@RestController
public class GoodsTypeController {

    @Reference(version = "1.0.0")
    GoodsTypeService goodsTypeService;

    BaseSingleTableController<GoodsTypeService, GoodsTypeDTO, GoodsType, GoodsTypeParam> bs=new BaseSingleTableController<>();
    /**
     * 获取信息
     *
     * @return
     */
    @GetMapping(value = "info")
    public ResponseResult<List<GoodsTypeDTO>> info() {
        return bs.info(goodsTypeService, new GoodsTypeDTO());
    }

    /**
     * 添加
     * @param goodsTypeParam
     * @return
     */
    @PostMapping(value = "add")
    public ResponseResult<Void> add(@RequestBody GoodsTypeParam goodsTypeParam){


        GoodsType goodsType=new GoodsType();
        return bs.add(goodsTypeService, goodsType, goodsTypeParam);
    }

    /**
     * 更新
     * @param goodsTypeDTO
     * @return
     */
    @PostMapping(value = "update")
    public ResponseResult<Void> update(@RequestBody GoodsTypeDTO goodsTypeDTO){
        GoodsType goodsType=new GoodsType();
        return bs.update(goodsTypeService, goodsType, goodsTypeDTO);
    }

    /**
     * 删除
     * @param goodsTypeDTO
     * @return
     */
    @PostMapping(value = "delete")
    public ResponseResult<Void> delete(@RequestBody GoodsTypeDTO goodsTypeDTO){
        Long id = goodsTypeDTO.getId();
        return bs.delete(goodsTypeService, id);
    }
}

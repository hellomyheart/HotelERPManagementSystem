package com.demo.hotel.business.controller;

import com.demo.hotel.business.base.controller.BaseTableController;
import com.demo.hotel.business.dto.GoodsProcurementBgDTO;
import com.demo.hotel.business.dto.GoodsProcurementDTO;
import com.demo.hotel.business.dto.param.GoodsProcurementParam;
import com.demo.hotel.commons.dto.ResponseResult;
import com.demo.hotel.provider.api.GoodsProcurementBgService;
import com.demo.hotel.provider.api.GoodsProcurementService;
import com.demo.hotel.provider.domain.GoodsProcurement;
import com.demo.hotel.provider.domain.GoodsProcurementBg;
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
@RequestMapping(value = "merchandiseProcurement/procurement")
@RestController
public class GoodsProcurementController {

    @Reference(version = "1.0.0")
    GoodsProcurementService goodsProcurementService;

    @Reference(version = "1.0.0")
    GoodsProcurementBgService goodsProcurementBgService;

    BaseTableController<GoodsProcurementService, GoodsProcurementBgService, GoodsProcurementDTO, GoodsProcurementBgDTO, GoodsProcurement, GoodsProcurementBg, GoodsProcurementParam> bt = new BaseTableController<>();

    /**
     * 获取
     *
     * @return
     */
    @GetMapping(value = "info")
    public ResponseResult<List<GoodsProcurementBgDTO>> info() {
        return bt.info(goodsProcurementBgService, new GoodsProcurementBgDTO());
    }

    /**
     * 添加
     * @param goodsProcurementParam
     * @return
     */
    @PostMapping(value = "add")
    public ResponseResult<Void> add(@RequestBody GoodsProcurementParam goodsProcurementParam) {
        GoodsProcurement goodsProcurement=new GoodsProcurement();
        BeanUtils.copyProperties(goodsProcurementParam,goodsProcurement);
        goodsProcurement.setCreateTime(new Date());
        return bt.add(goodsProcurementService, goodsProcurement);
    }

    /**
     * 更新
     * @param goodsProcurementDTO
     * @return
     */
    @PostMapping(value = "update")
    public ResponseResult<Void> update(@RequestBody GoodsProcurementDTO goodsProcurementDTO) {

        return bt.update(goodsProcurementService,new GoodsProcurement(),goodsProcurementDTO);
    }

    /**
     * 删除
     * @param goodsProcurementDTO
     * @return
     */
    @PostMapping(value = "delete")
    public ResponseResult<Void> delete(@RequestBody GoodsProcurementDTO goodsProcurementDTO) {
        Long id = goodsProcurementDTO.getId();
        return bt.delete(goodsProcurementService, id);
    }
}

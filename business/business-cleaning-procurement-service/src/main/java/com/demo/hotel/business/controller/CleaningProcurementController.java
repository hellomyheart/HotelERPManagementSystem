package com.demo.hotel.business.controller;

import com.demo.hotel.business.base.controller.BaseTableController;
import com.demo.hotel.business.dto.CleaningProcurementBcDTO;
import com.demo.hotel.business.dto.CleaningProcurementDTO;
import com.demo.hotel.business.dto.param.CleaningProcurementParam;
import com.demo.hotel.commons.dto.ResponseResult;
import com.demo.hotel.provider.api.CleaningProcurementBcService;
import com.demo.hotel.provider.api.CleaningProcurementService;
import com.demo.hotel.provider.domain.CleaningProcurement;
import com.demo.hotel.provider.domain.CleaningProcurementBc;
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
@RequestMapping(value = "cleaningProcurement/procurement")
@RestController
public class CleaningProcurementController {

    @Reference(version = "1.0.0")
    CleaningProcurementService cleaningProcurementService;

    @Reference(version = "1.0.0")
    CleaningProcurementBcService cleaningProcurementBcService;

    BaseTableController<CleaningProcurementService, CleaningProcurementBcService, CleaningProcurementDTO, CleaningProcurementBcDTO, CleaningProcurement, CleaningProcurementBc, CleaningProcurementParam> bt = new BaseTableController<>();

    /**
     * 获取
     *
     * @return
     */
    @GetMapping(value = "info")
    public ResponseResult<List<CleaningProcurementBcDTO>> info() {
        return bt.info(cleaningProcurementBcService, new CleaningProcurementBcDTO());
    }

    /**
     * 添加
     * @param param
     * @return
     */
    @PostMapping(value = "add")
    public ResponseResult<Void> add(@RequestBody CleaningProcurementParam param) {
       CleaningProcurement cleaningProcurement=new CleaningProcurement();
        BeanUtils.copyProperties(param,cleaningProcurement);
        cleaningProcurement.setCreatTime(LocalDate.now());
        return bt.add(cleaningProcurementService, cleaningProcurement);
    }

    /**
     * 更新
     * @param dTO
     * @return
     */
    @PostMapping(value = "update")
    public ResponseResult<Void> update(@RequestBody CleaningProcurementDTO dTO) {

        return bt.update(cleaningProcurementService,new CleaningProcurement(),dTO);
    }

    /**
     * 删除
     * @param dTO
     * @return
     */
    @PostMapping(value = "delete")
    public ResponseResult<Void> delete(@RequestBody CleaningProcurementDTO dTO) {
        Long id = dTO.getId();
        return bt.delete(cleaningProcurementService, id);
    }
}

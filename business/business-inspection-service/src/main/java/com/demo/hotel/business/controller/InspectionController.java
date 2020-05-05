package com.demo.hotel.business.controller;
import java.util.Date;

import com.demo.hotel.business.base.controller.BaseSingleTableController;
import com.demo.hotel.business.dto.InspectionDTO;
import com.demo.hotel.business.dto.param.InspectionParam;
import com.demo.hotel.commons.dto.ResponseResult;
import com.demo.hotel.provider.api.InspectionService;
import com.demo.hotel.provider.domain.Inspection;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
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
@RequestMapping(value = "inspection/scheduled")
@RestController
public class InspectionController {

    @Reference(version = "1.0.0")
    InspectionService service;

    BaseSingleTableController<InspectionService, InspectionDTO, Inspection, InspectionParam> bs=new BaseSingleTableController<>();
    /**
     * 获取信息
     *
     * @return
     */
    @GetMapping(value = "info")
    public ResponseResult<List<InspectionDTO>> info() {
        return bs.info(service, new InspectionDTO());
    }

    /**
     * 添加信息
     * @param param
     * @return
     */
    @PostMapping(value = "add")
    public ResponseResult<Void> add(@RequestBody InspectionParam param){
        Inspection inspection=new Inspection();
        BeanUtils.copyProperties(param,inspection);
        inspection.setInspectionTime(new Date());

        return bs.add(service, inspection);
    }

    /**
     * 更新信息
     * @param dTO
     * @return
     */
    @PostMapping(value = "update")
    public ResponseResult<Void> update(@RequestBody InspectionDTO dTO){
        Inspection inspection=new Inspection();
        return bs.update(service, inspection, dTO);
    }

    /**
     * 删除
     * @param dTO
     * @return
     */
    @PostMapping(value = "delete")
    public ResponseResult<Void> delete(@RequestBody InspectionDTO dTO){
        Long id = dTO.getId();
        return bs.delete(service, id);
    }
}

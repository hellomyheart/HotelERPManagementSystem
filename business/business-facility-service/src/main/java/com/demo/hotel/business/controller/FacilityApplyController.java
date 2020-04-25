package com.demo.hotel.business.controller;

import com.demo.hotel.business.base.controller.BaseTableController;
import com.demo.hotel.business.dto.FacilityApplyDTO;
import com.demo.hotel.business.dto.FacilityApplyEDTO;
import com.demo.hotel.business.dto.param.FacilityApplyParam;
import com.demo.hotel.commons.dto.ResponseResult;
import com.demo.hotel.provider.api.FacilityApplyEService;
import com.demo.hotel.provider.api.FacilityApplyService;
import com.demo.hotel.provider.domain.FacilityApply;
import com.demo.hotel.provider.domain.FacilityApplyE;
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
@RequestMapping(value = "facility/apply")
@RestController
public class FacilityApplyController {

    @Reference(version = "1.0.0")
    FacilityApplyService facilityApplyService;

    @Reference(version = "1.0.0")
    FacilityApplyEService facilityApplyEService;

    BaseTableController<FacilityApplyService, FacilityApplyEService, FacilityApplyDTO, FacilityApplyEDTO, FacilityApply, FacilityApplyE, FacilityApplyParam> bt = new BaseTableController<>();

    /**
     * 获取信息
     *
     * @return
     */
    @GetMapping(value = "info")
    public ResponseResult<List<FacilityApplyEDTO>> info() {
        return bt.info(facilityApplyEService, new FacilityApplyEDTO());
    }

    /**
     * 添加
     *
     * @param facilityApplyParam
     * @return
     */
    @PostMapping(value = "add")
    public ResponseResult<Void> add(@RequestBody FacilityApplyParam facilityApplyParam) {
        FacilityApply facilityApply = new FacilityApply();
        BeanUtils.copyProperties(facilityApplyParam, facilityApply);
        facilityApply.setCreateTime(new Date());
        facilityApply.setStatus(0);
        facilityApply.setTotalPrice(facilityApply.getPrice()*facilityApply.getQuantity());

        return bt.add(facilityApplyService, facilityApply);
    }

    /**
     * 申请通过
     *
     * @param facilityApplyDTO
     * @return
     */
    @PostMapping(value = "update")
    public ResponseResult<Void> update(@RequestBody FacilityApplyDTO facilityApplyDTO) {
        FacilityApply facilityApply = new FacilityApply();
        BeanUtils.copyProperties(facilityApplyDTO,facilityApply);
        facilityApply.setStatus(1);
        return bt.update(facilityApplyService, facilityApply);
    }

    /**
     * 删除
     *
     * @param facilityApplyDTO
     * @return
     */
    @PostMapping(value = "delete")
    public ResponseResult<Void> delete(@RequestBody FacilityApplyDTO facilityApplyDTO) {
        Long id = facilityApplyDTO.getId();
        return bt.delete(facilityApplyService, id);
    }
}

package com.demo.hotel.business.controller;

import com.demo.hotel.business.base.controller.BaseTableController;
import com.demo.hotel.business.dto.CashApplyDTO;
import com.demo.hotel.business.dto.CashApplyEDTO;
import com.demo.hotel.business.dto.param.CashApplyParam;
import com.demo.hotel.commons.dto.ResponseResult;
import com.demo.hotel.provider.api.CashApplyEService;
import com.demo.hotel.provider.api.CashApplyService;
import com.demo.hotel.provider.domain.CashApply;
import com.demo.hotel.provider.domain.CashApplyE;
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
 * @description: 职工控制器
 * @author: syj
 * @create: 2020-04-03 16:52
 **/
@RequestMapping(value = "budget/apply")
@RestController
public class ApplyController {

    @Reference(version = "1.0.0")
    CashApplyService cashApplyService;

    @Reference(version = "1.0.0")
    CashApplyEService cashApplyEService;

    BaseTableController<CashApplyService, CashApplyEService, CashApplyDTO, CashApplyEDTO, CashApply, CashApplyE, CashApplyParam> bt = new BaseTableController<>();

    /**
     * 获取信息
     *
     * @return
     */
    @GetMapping(value = "info")
    public ResponseResult<List<CashApplyEDTO>> info() {
        return bt.info(cashApplyEService, new CashApplyEDTO());
    }

    /**
     * 添加
     *
     * @param cashApplyParam
     * @return
     */
    @PostMapping(value = "add")
    public ResponseResult<Void> add(@RequestBody CashApplyParam cashApplyParam) {
        CashApply cashApply = new CashApply();
        BeanUtils.copyProperties(cashApplyParam, cashApply);
        cashApply.setCreateTime(new Date());
        return bt.add(cashApplyService, cashApply);
    }

    /**
     * 更新
     *
     * @param cashApplyDTO
     * @return
     */
    @PostMapping(value = "update")
    public ResponseResult<Void> update(@RequestBody CashApplyDTO cashApplyDTO) {
        CashApply cashApply = new CashApply();
        BeanUtils.copyProperties(cashApplyDTO, cashApply);
        return bt.update(cashApplyService, cashApply);
    }

    /**
     * 删除
     *
     * @param cashApplyDTO
     * @return
     */
    @PostMapping(value = "delete")
    public ResponseResult<Void> delete(@RequestBody CashApplyDTO cashApplyDTO) {
        Long id = cashApplyDTO.getId();
        return bt.delete(cashApplyService, id);
    }
}

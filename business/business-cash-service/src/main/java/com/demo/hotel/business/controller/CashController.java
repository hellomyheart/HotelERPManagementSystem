package com.demo.hotel.business.controller;

import com.demo.hotel.business.base.controller.BaseSingleTableController;
import com.demo.hotel.business.dto.CashFlowDTO;
import com.demo.hotel.business.dto.param.CashFlowParam;
import com.demo.hotel.commons.dto.ResponseResult;
import com.demo.hotel.provider.api.CashFlowService;
import com.demo.hotel.provider.domain.CashFlow;
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
 * @description: 资金流动控制器
 * @author: syj
 * @create: 2020-04-03 16:52
 **/
@RequestMapping(value = "cash/flow")
@RestController
public class CashController {

    @Reference(version = "1.0.0")
    CashFlowService cashFlowService;

    BaseSingleTableController<CashFlowService, CashFlowDTO, CashFlow, CashFlowParam> bs = new BaseSingleTableController<>();

    /**
     * 获取信息
     *
     * @return
     */
    @GetMapping(value = "info")
    public ResponseResult<List<CashFlowDTO>> info() {
        return bs.info(cashFlowService, new CashFlowDTO());
    }

    /**
     * 添加信息
     *
     * @param cashFlowParam
     * @return
     */
    @PostMapping(value = "add")
    public ResponseResult<Void> add(@RequestBody CashFlowParam cashFlowParam) {


        CashFlow cashFlow = new CashFlow();
        return bs.add(cashFlowService, cashFlow, cashFlowParam);
    }

    /**
     * 不允许更新信息
     *
     * @param cashFlowDTO
     * @return
     */
    @PostMapping(value = "update")
    public ResponseResult<Void> update(@RequestBody CashFlowDTO cashFlowDTO) {
        CashFlow cashFlow = new CashFlow();
        return null;
    }

    /**
     * 删除信息
     *
     * @param cashFlowDTO
     * @return
     */
    @PostMapping(value = "delete")
    public ResponseResult<Void> delete(@RequestBody CashFlowDTO cashFlowDTO) {
        Long id = cashFlowDTO.getId();
        return bs.delete(cashFlowService, id);
    }
}

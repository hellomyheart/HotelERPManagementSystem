package com.demo.hotel.business.feign.fallback;

import com.demo.hotel.business.dto.CashFlowDTO;
import com.demo.hotel.business.dto.param.CashFlowParam;
import com.demo.hotel.business.feign.CashFlowFeign;
import org.springframework.stereotype.Component;


/**
 * @program: HotelERPManagementSystem
 * @description:
 * @author: syj
 * @create: 2020-04-03 16:46
 **/
@Component
public class CashFlowFeignFallback implements CashFlowFeign {

    CommonsFeignFallback<Void> cf = new CommonsFeignFallback<>();

    @Override
    public String info() {
        return cf.message();
    }

    @Override
    public String add(CashFlowParam cashFlowParam) {
        return cf.message();
    }

    @Override
    public String update(CashFlowDTO cashFlowDTO) {
        return cf.message();
    }

    @Override
    public String delete(CashFlowDTO cashFlowDTO) {
        return cf.message();
    }
}
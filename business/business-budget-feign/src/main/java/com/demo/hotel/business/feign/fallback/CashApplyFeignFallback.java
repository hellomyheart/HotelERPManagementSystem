package com.demo.hotel.business.feign.fallback;

import com.demo.hotel.business.dto.CashApplyDTO;
import com.demo.hotel.business.dto.param.CashApplyParam;
import com.demo.hotel.business.feign.CashApplyFeign;
import org.springframework.stereotype.Component;

/**
 * @program: HotelERPManagementSystem
 * @description:
 * @author: syj
 * @create: 2020-04-03 16:46
 **/
@Component
public class CashApplyFeignFallback implements CashApplyFeign {

    CommonsFeignFallback<Void> cf=new CommonsFeignFallback<>();

    @Override
    public String info() {
        return cf.message();
    }

    @Override
    public String add(CashApplyParam departmentParam) {
        return cf.message();
    }

    @Override
    public String update(CashApplyDTO departmentDTO) {
        return cf.message();
    }

    @Override
    public String delete(CashApplyDTO departmentDTO) {
        return cf.message();
    }
}
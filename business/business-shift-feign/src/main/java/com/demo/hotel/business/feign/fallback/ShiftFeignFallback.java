package com.demo.hotel.business.feign.fallback;

import com.demo.hotel.business.dto.ShiftDTO;
import com.demo.hotel.business.dto.param.ShiftParam;
import com.demo.hotel.business.feign.ShiftFeign;
import com.demo.hotel.commons.dto.CodeStatus;
import org.springframework.stereotype.Component;

/**
 * @program: HotelERPManagementSystem
 * @description: 排班FeignFallback
 * @author: syj
 * @create: 2020-04-07 18:02
 **/
@Component
public class ShiftFeignFallback implements ShiftFeign {

    CommonsFeignFallback<Void> cf=new CommonsFeignFallback<>();
    @Override
    public String info() {
        return cf.message();
    }

    @Override
    public String add(ShiftParam shiftParam) {
        return cf.message();
    }

    @Override
    public String update(ShiftDTO shiftDTO) {
        return cf.message();
    }

    @Override
    public String delete(ShiftDTO shiftDTO) {
        return cf.message();
    }
}

package com.demo.hotel.business.feign.fallback;

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

    CommonsFeignFallback<Void> commonsFeignFallback=new CommonsFeignFallback<>();
    @Override
    public String info() {
        return commonsFeignFallback.message(CodeStatus.BREAKING, FeignFallbackMessage.BREAKING_MESSAGE);
    }

    @Override
    public String add(ShiftParam shiftParam) {
        return commonsFeignFallback.message(CodeStatus.BREAKING, FeignFallbackMessage.BREAKING_MESSAGE);
    }

    @Override
    public String update(ShiftParam shiftParam) {
        return commonsFeignFallback.message(CodeStatus.BREAKING, FeignFallbackMessage.BREAKING_MESSAGE);
    }

    @Override
    public String delete(Long id) {
        return commonsFeignFallback.message(CodeStatus.BREAKING, FeignFallbackMessage.BREAKING_MESSAGE);
    }
}

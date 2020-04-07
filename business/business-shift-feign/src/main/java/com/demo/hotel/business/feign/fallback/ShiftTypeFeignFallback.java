package com.demo.hotel.business.feign.fallback;

import com.demo.hotel.business.dto.ShiftTypeDTO;
import com.demo.hotel.business.dto.param.ShiftTypeParam;
import com.demo.hotel.business.feign.ShiftTypeFeign;
import com.demo.hotel.commons.dto.CodeStatus;
import org.springframework.stereotype.Component;

/**
 * @program: HotelERPManagementSystem
 * @description: 排班分类FeignFallback
 * @author: syj
 * @create: 2020-04-07 17:59
 **/
@Component
public class ShiftTypeFeignFallback implements ShiftTypeFeign {

    CommonsFeignFallback<Void> commonsFeignFallback=new CommonsFeignFallback<>();

    @Override
    public String info() {
        return commonsFeignFallback.message(CodeStatus.BREAKING, FeignFallbackMessage.BREAKING_MESSAGE);
    }

    @Override
    public String add(ShiftTypeParam shiftTypeParam) {
        return commonsFeignFallback.message(CodeStatus.BREAKING, FeignFallbackMessage.BREAKING_MESSAGE);
    }

    @Override
    public String update(ShiftTypeDTO shiftTypeDTO) {
        return commonsFeignFallback.message(CodeStatus.BREAKING, FeignFallbackMessage.BREAKING_MESSAGE);
    }

    @Override
    public String delete(Long id) {
        return commonsFeignFallback.message(CodeStatus.BREAKING, FeignFallbackMessage.BREAKING_MESSAGE);
    }
}

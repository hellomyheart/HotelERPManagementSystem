package com.demo.hotel.business.feign.fallback;

import com.demo.hotel.business.dto.PositionDTO;
import com.demo.hotel.business.dto.param.PositionParam;
import com.demo.hotel.business.feign.PositionFeign;
import com.demo.hotel.commons.dto.CodeStatus;
import org.springframework.stereotype.Component;

/**
 * @program: HotelERPManagementSystem
 * @description: Fallback类
 * @author: syj
 * @create: 2020-04-06 17:27
 **/

@Component
public class PositionFeignFallback implements PositionFeign {

    CommonsFeignFallback<Void> commonsFeignFallback=new CommonsFeignFallback<>();

    @Override
    public String info() {
        return commonsFeignFallback.message(CodeStatus.BREAKING, FeignFallbackMessage.BREAKING_MESSAGE);
    }

    @Override
    public String add(PositionParam PositionParam) {
        return commonsFeignFallback.message(CodeStatus.BREAKING, FeignFallbackMessage.BREAKING_MESSAGE);
    }

    @Override
    public String update(PositionDTO positionDTO) {
        return commonsFeignFallback.message(CodeStatus.BREAKING, FeignFallbackMessage.BREAKING_MESSAGE);
    }

    @Override
    public String delete(Long id) {
        return commonsFeignFallback.message(CodeStatus.BREAKING, FeignFallbackMessage.BREAKING_MESSAGE);
    }
}

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

    CommonsFeignFallback<Void> cf=new CommonsFeignFallback<>();

    @Override
    public String info() {
        return cf.message();
    }

    @Override
    public String add(PositionParam PositionParam) {
        return cf.message();
    }

    @Override
    public String update(PositionDTO positionDTO) {
        return cf.message();
    }

    @Override
    public String delete(PositionDTO positionDTO) {
        return cf.message();
    }
}

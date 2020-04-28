package com.demo.hotel.business.feign.fallback;

import com.demo.hotel.business.dto.CleaningDTO;
import com.demo.hotel.business.dto.param.NullParam;
import com.demo.hotel.business.feign.CleaningFeign;
import org.springframework.stereotype.Component;

/**
 * @program: HotelERPManagementSystem
 * @description:
 * @author: syj
 * @create: 2020-04-03 16:46
 **/
@Component
public class CleaningFeignFallback implements CleaningFeign {

    CommonsFeignFallback<Void> cf=new CommonsFeignFallback<>();


    @Override
    public String info() {
        return cf.message();
    }

    @Override
    public String add(NullParam nullParam) {
        return null;
    }

    @Override
    public String update(CleaningDTO goodsDTO) {
        return cf.message();
    }

    @Override
    public String delete(CleaningDTO goodsDTO) {
        return null;
    }
}
package com.demo.hotel.business.feign.fallback;

import com.demo.hotel.business.dto.FoodDTO;
import com.demo.hotel.business.dto.param.NullParam;
import com.demo.hotel.business.feign.FoodFeign;
import org.springframework.stereotype.Component;

/**
 * @program: HotelERPManagementSystem
 * @description:
 * @author: syj
 * @create: 2020-04-03 16:46
 **/
@Component
public class FoodFeignFallback implements FoodFeign {

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
    public String update(FoodDTO goodsDTO) {
        return cf.message();
    }

    @Override
    public String delete(FoodDTO goodsDTO) {
        return null;
    }
}
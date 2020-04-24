package com.demo.hotel.business.feign.fallback;

import com.demo.hotel.business.dto.TrainingContentDTO;
import com.demo.hotel.business.dto.param.TrainingContentParam;
import com.demo.hotel.business.feign.TrainingContentFeign;
import com.demo.hotel.commons.dto.CodeStatus;
import org.springframework.stereotype.Component;

/**
 * @program: HotelERPManagementSystem
 * @description:
 * @author: syj
 * @create: 2020-04-07 07:42
 **/
@Component
public class TrainingContentFeignFallback implements TrainingContentFeign {
    CommonsFeignFallback<Void> cf=new CommonsFeignFallback<>();

    @Override
    public String info() {
        return cf.message();
    }

    @Override
    public String add(TrainingContentParam trainingContentParam) {
        return cf.message();
    }

    @Override
    public String update(TrainingContentDTO trainingContentDTO) {
        return cf.message();
    }

    @Override
    public String delete(TrainingContentDTO trainingContentDTO) {
        return cf.message();
    }
}

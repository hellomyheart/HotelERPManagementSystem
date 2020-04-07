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
    CommonsFeignFallback<Void> commonsFeignFallback=new CommonsFeignFallback<>();

    @Override
    public String info() {
        return commonsFeignFallback.message(CodeStatus.BREAKING, FeignFallbackMessage.BREAKING_MESSAGE);
    }

    @Override
    public String add(TrainingContentParam trainingContentParam) {
        return commonsFeignFallback.message(CodeStatus.BREAKING, FeignFallbackMessage.BREAKING_MESSAGE);
    }

    @Override
    public String update(TrainingContentDTO trainingContentDTO) {
        return commonsFeignFallback.message(CodeStatus.BREAKING, FeignFallbackMessage.BREAKING_MESSAGE);
    }

    @Override
    public String delete(Long id) {
        return commonsFeignFallback.message(CodeStatus.BREAKING, FeignFallbackMessage.BREAKING_MESSAGE);
    }
}

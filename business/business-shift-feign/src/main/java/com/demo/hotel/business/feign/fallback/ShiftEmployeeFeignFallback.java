package com.demo.hotel.business.feign.fallback;

import com.demo.hotel.business.dto.ShiftEmployeeDTO;
import com.demo.hotel.business.dto.param.ShiftEmployeeParam;
import com.demo.hotel.business.feign.ShiftEmployeeFeign;
import com.demo.hotel.commons.dto.CodeStatus;
import org.springframework.stereotype.Component;

/**
 * @program: HotelERPManagementSystem
 * @description: 职工排班FeignFallback
 * @author: syj
 * @create: 2020-04-07 18:10
 **/
@Component
public class ShiftEmployeeFeignFallback implements ShiftEmployeeFeign {

    CommonsFeignFallback<Void> commonsFeignFallback=new CommonsFeignFallback<>();
    @Override
    public String info() {
        return commonsFeignFallback.message(CodeStatus.BREAKING, FeignFallbackMessage.BREAKING_MESSAGE);
    }

    @Override
    public String add(ShiftEmployeeParam shiftEmployeeParam) {
        return commonsFeignFallback.message(CodeStatus.BREAKING, FeignFallbackMessage.BREAKING_MESSAGE);
    }

    @Override
    public String update(ShiftEmployeeDTO shiftEmployeeDTO) {
        return commonsFeignFallback.message(CodeStatus.BREAKING, FeignFallbackMessage.BREAKING_MESSAGE);
    }

    @Override
    public String delete(ShiftEmployeeDTO shiftEmployeeDTO) {
        return commonsFeignFallback.message(CodeStatus.BREAKING, FeignFallbackMessage.BREAKING_MESSAGE);
    }
}

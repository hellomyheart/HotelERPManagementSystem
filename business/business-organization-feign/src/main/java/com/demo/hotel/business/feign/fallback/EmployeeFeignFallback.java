package com.demo.hotel.business.feign.fallback;

import com.demo.hotel.business.dto.param.EmployeeParam;
import com.demo.hotel.business.feign.EmployeeFeign;
import com.demo.hotel.commons.dto.CodeStatus;
import org.springframework.stereotype.Component;

/**
 * @program: HotelERPManagementSystem
 * @description: EmployeeFeignFallback
 * @author: syj
 * @create: 2020-04-06 19:19
 **/
@Component
public class EmployeeFeignFallback implements EmployeeFeign {

    CommonsFeignFallback<Void> commonsFeignFallback=new CommonsFeignFallback<>();
    @Override
    public String info() {
        return commonsFeignFallback.message(CodeStatus.BREAKING, FeignFallbackMessage.BREAKING_MESSAGE);
    }

    @Override
    public String add(EmployeeParam employeeParam) {
        return commonsFeignFallback.message(CodeStatus.BREAKING, FeignFallbackMessage.BREAKING_MESSAGE);
    }

    @Override
    public String update(EmployeeParam employeeParam) {
        return commonsFeignFallback.message(CodeStatus.BREAKING, FeignFallbackMessage.BREAKING_MESSAGE);
    }

    @Override
    public String delete(Long id) {
        return commonsFeignFallback.message(CodeStatus.BREAKING, FeignFallbackMessage.BREAKING_MESSAGE);
    }
}

package com.demo.hotel.business.feign.fallback;

import com.demo.hotel.business.dto.EmployeeDTO;
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

    CommonsFeignFallback<Void> cf=new CommonsFeignFallback<>();
    @Override
    public String info() {
        return cf.message();
    }

    @Override
    public String add(EmployeeParam employeeParam) {
        return cf.message();
    }


    @Override
    public String update(EmployeeDTO employeeDTO) {
        return cf.message();
    }

    @Override
    public String delete(EmployeeDTO employeeDTO) {
        return cf.message();
    }
}

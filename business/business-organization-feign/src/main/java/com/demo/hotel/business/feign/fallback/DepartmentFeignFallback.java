package com.demo.hotel.business.feign.fallback;

import com.demo.hotel.business.dto.DepartmentDTO;
import com.demo.hotel.business.dto.param.DepartmentParam;
import com.demo.hotel.business.feign.DepartmentFeign;
import com.demo.hotel.commons.dto.CodeStatus;
import org.springframework.stereotype.Component;

/**
 * @program: HotelERPManagementSystem
 * @description:
 * @author: syj
 * @create: 2020-04-03 16:46
 **/
@Component
public class DepartmentFeignFallback implements DepartmentFeign {

    @Override
    public String departmentInfo() {
        return new CommonsFeignFallback().Message(CodeStatus.BREAKING, FeignFallbackMessage.BREAKING_MESSAGE);
    }

    @Override
    public String add(DepartmentParam departmentParam) {
        return new CommonsFeignFallback().Message(CodeStatus.BREAKING, FeignFallbackMessage.BREAKING_MESSAGE);
    }

    @Override
    public String update(DepartmentDTO departmentDTO) {
        return new CommonsFeignFallback().Message(CodeStatus.BREAKING, FeignFallbackMessage.BREAKING_MESSAGE);
    }

    @Override
    public String delete(Long id) {
        return new CommonsFeignFallback().Message(CodeStatus.BREAKING, FeignFallbackMessage.BREAKING_MESSAGE);
    }
}
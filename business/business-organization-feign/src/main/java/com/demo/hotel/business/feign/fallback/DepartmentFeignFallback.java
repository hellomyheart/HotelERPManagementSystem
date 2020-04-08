package com.demo.hotel.business.feign.fallback;

import com.demo.hotel.business.dto.DepartmentDTO;
import com.demo.hotel.business.dto.param.DepartmentParam;
import com.demo.hotel.business.feign.DepartmentFeign;
import com.demo.hotel.commons.dto.CodeStatus;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @program: HotelERPManagementSystem
 * @description:
 * @author: syj
 * @create: 2020-04-03 16:46
 **/
@Component
public class DepartmentFeignFallback implements DepartmentFeign {

    CommonsFeignFallback<Void> commonsFeignFallback=new CommonsFeignFallback<>();

    @Override
    public String info() {
        return commonsFeignFallback.message(CodeStatus.BREAKING, FeignFallbackMessage.BREAKING_MESSAGE);
    }

    @Override
    public String add(DepartmentParam departmentParam) {
        return commonsFeignFallback.message(CodeStatus.BREAKING, FeignFallbackMessage.BREAKING_MESSAGE);
    }

    @Override
    public String update(DepartmentDTO departmentDTO) {
        return commonsFeignFallback.message(CodeStatus.BREAKING, FeignFallbackMessage.BREAKING_MESSAGE);
    }

    @Override
    public String delete(DepartmentDTO departmentDTO) {
        return commonsFeignFallback.message(CodeStatus.BREAKING, FeignFallbackMessage.BREAKING_MESSAGE);
    }
}
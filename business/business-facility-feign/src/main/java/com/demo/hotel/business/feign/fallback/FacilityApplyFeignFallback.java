package com.demo.hotel.business.feign.fallback;

import com.demo.hotel.business.dto.FacilityApplyDTO;
import com.demo.hotel.business.dto.param.FacilityApplyParam;
import com.demo.hotel.business.feign.FacilityApplyFeign;
import org.springframework.stereotype.Component;

/**
 * @program: HotelERPManagementSystem
 * @description: EmployeeFeignFallback
 * @author: syj
 * @create: 2020-04-06 19:19
 **/
@Component
public class FacilityApplyFeignFallback implements FacilityApplyFeign {

    CommonsFeignFallback<Void> cf=new CommonsFeignFallback<>();
    @Override
    public String info() {
        return cf.message();
    }

    @Override
    public String add(FacilityApplyParam facilityApplyParam) {
        return cf.message();
    }


    @Override
    public String update(FacilityApplyDTO facilityApplyDTO) {
        return cf.message();
    }

    @Override
    public String delete(FacilityApplyDTO facilityApplyDTO) {
        return cf.message();
    }
}

package com.demo.hotel.business.feign;

import com.demo.hotel.business.dto.ShiftEmployeeDTO;
import com.demo.hotel.business.dto.param.ShiftEmployeeParam;
import com.demo.hotel.business.dto.param.ShiftParam;
import com.demo.hotel.business.feign.fallback.ShiftEmployeeFeignFallback;
import com.demo.hotel.configuration.FeignRequestConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @program: HotelERPManagementSystem
 * @description: 职工排班Feign
 * @author: syj
 * @create: 2020-04-07 18:09
 **/
@FeignClient(value = "business-shift", path = "shift/employee", configuration = FeignRequestConfiguration.class, fallback = ShiftEmployeeFeignFallback.class)
public interface ShiftEmployeeFeign extends BaseFeign<ShiftEmployeeParam, ShiftEmployeeDTO>{

}

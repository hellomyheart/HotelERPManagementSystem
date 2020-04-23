package com.demo.hotel.business.feign;

import com.demo.hotel.business.dto.ShiftDTO;
import com.demo.hotel.business.dto.param.ShiftParam;
import com.demo.hotel.business.feign.fallback.ShiftFeignFallback;
import com.demo.hotel.configuration.FeignRequestConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @program: HotelERPManagementSystem
 * @description: 排班Feign
 * @author: syj
 * @create: 2020-04-07 18:01
 **/
@FeignClient(value = "business-shift", path = "shift/content", configuration = FeignRequestConfiguration.class, fallback = ShiftFeignFallback.class)
public interface ShiftFeign extends BaseFeign<ShiftParam, ShiftDTO>{

}

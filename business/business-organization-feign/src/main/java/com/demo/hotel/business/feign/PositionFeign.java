package com.demo.hotel.business.feign;

import com.demo.hotel.business.dto.PositionDTO;
import com.demo.hotel.business.dto.param.PositionParam;
import com.demo.hotel.business.feign.fallback.PositionFeignFallback;
import com.demo.hotel.configuration.FeignRequestConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @program: HotelERPManagementSystem
 * @description: 职位Feign
 * @author: syj
 * @create: 2020-04-06 17:20
 **/

//value指向服务名，application
//path对应controller中的ResquestMapping
//feign类似于http客户端
//configuration = FeignRequestConfiguration.class是为了配置拦截器在请求头中加token
@FeignClient(value = "business-organization", path = "organization/position", configuration = FeignRequestConfiguration.class, fallback = PositionFeignFallback.class)
public interface PositionFeign extends BaseFeign<PositionParam,PositionDTO>{

}

package com.demo.hotel.business.feign;

import com.demo.hotel.business.dto.TrainingDTO;
import com.demo.hotel.business.dto.param.TrainingParam;
import com.demo.hotel.business.feign.fallback.TrainingFeignFallback;
import com.demo.hotel.configuration.FeignRequestConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @program: HotelERPManagementSystem
 * @description: TrainingFeign
 * @author: syj
 * @create: 2020-04-07 07:46
 **/


//value指向服务名，application
//path对应controller中的ResquestMapping
//feign类似于http客户端
//configuration = FeignRequestConfiguration.class是为了配置拦截器在请求头中加token
@FeignClient(value = "business-training", path = "train/training", configuration = FeignRequestConfiguration.class, fallback = TrainingFeignFallback.class)
public interface TrainingFeign extends BaseFeign<TrainingParam, TrainingDTO> {

}

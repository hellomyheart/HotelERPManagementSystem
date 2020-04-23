package com.demo.hotel.business.feign;

import com.demo.hotel.business.dto.TrainingContentDTO;
import com.demo.hotel.business.dto.param.TrainingContentParam;
import com.demo.hotel.business.feign.fallback.TrainingContentFeignFallback;
import com.demo.hotel.configuration.FeignRequestConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @program: HotelERPManagementSystem
 * @description: 培训内容Feign
 * @author: syj
 * @create: 2020-04-07 07:37
 **/


//value指向服务名，application
//path对应controller中的ResquestMapping
//feign类似于http客户端
//configuration = FeignRequestConfiguration.class是为了配置拦截器在请求头中加token
@FeignClient(value = "business-training", path = "train/content", configuration = FeignRequestConfiguration.class, fallback = TrainingContentFeignFallback.class)
public interface TrainingContentFeign extends BaseFeign<TrainingContentParam,TrainingContentDTO>{

}

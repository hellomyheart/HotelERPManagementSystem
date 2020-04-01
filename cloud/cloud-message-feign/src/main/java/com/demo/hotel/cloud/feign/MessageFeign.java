package com.demo.hotel.cloud.feign;

import com.demo.hotel.cloud.feign.fallback.MessageFeignFallback;
import com.demo.hotel.configuration.FeignRequestConfiguration;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "cloud-message", path = "message", configuration = FeignRequestConfiguration.class, fallback = MessageFeignFallback.class)
public interface MessageFeign {

}

package com.demo.hotel.business.feign;

import com.demo.hotel.business.dto.CashFlowDTO;
import com.demo.hotel.business.dto.param.CashFlowParam;
import com.demo.hotel.business.feign.fallback.CashFlowFeignFallback;
import com.demo.hotel.configuration.FeignRequestConfiguration;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @program: HotelERPManagementSystem
 * @description: 资金流动feign
 * @author: syj
 * @create: 2020-04-24 18:10
 **/

//value指向服务名，application
//path对应controller中的ResquestMapping
//feign类似于http客户端
//configuration = FeignRequestConfiguration.class是为了配置拦截器在请求头中加token
@FeignClient(value = "business-cash", path = "cash/flow", configuration = FeignRequestConfiguration.class, fallback = CashFlowFeignFallback.class)
public interface CashFlowFeign extends BaseFeign<CashFlowParam, CashFlowDTO> {
}

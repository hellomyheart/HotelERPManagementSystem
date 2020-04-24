package com.demo.hotel.business.feign;

import com.demo.hotel.business.dto.CashApplyDTO;
import com.demo.hotel.business.dto.param.CashApplyParam;
import com.demo.hotel.business.feign.fallback.CashApplyFeignFallback;
import com.demo.hotel.configuration.FeignRequestConfiguration;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @program: HotelERPManagementSystem
 * @description: 部门Feign
 * @author: syj
 * @create: 2020-04-03 16:04
 **/

//value指向服务名，application
//path对应controller中的ResquestMapping
//feign类似于http客户端
//configuration = FeignRequestConfiguration.class是为了配置拦截器在请求头中加token
@FeignClient(value = "business-budget", path = "budget/apply", configuration = FeignRequestConfiguration.class, fallback = CashApplyFeignFallback.class)
public interface CashApplyFeign extends BaseFeign<CashApplyParam, CashApplyDTO> {

}

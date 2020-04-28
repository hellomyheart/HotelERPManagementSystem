package com.demo.hotel.business.feign;

import com.demo.hotel.business.dto.GoodsDTO;
import com.demo.hotel.business.dto.param.NullParam;
import com.demo.hotel.business.feign.fallback.GoodsFeignFallback;
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
@FeignClient(value = "business-merchandise-inventory", path = "merchandise/inventory", configuration = FeignRequestConfiguration.class, fallback = GoodsFeignFallback.class)
public interface GoodsFeign extends BaseFeign<NullParam, GoodsDTO> {

}

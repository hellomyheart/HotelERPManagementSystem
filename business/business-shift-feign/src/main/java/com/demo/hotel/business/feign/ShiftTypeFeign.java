package com.demo.hotel.business.feign;

import com.demo.hotel.business.dto.ShiftTypeDTO;
import com.demo.hotel.business.dto.param.ShiftTypeParam;
import com.demo.hotel.business.feign.fallback.ShiftTypeFeignFallback;
import com.demo.hotel.configuration.FeignRequestConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @program: HotelERPManagementSystem
 * @description: 排班分类Feign
 * @author: syj
 * @create: 2020-04-07 17:46
 **/


//value指向服务名，application
//path对应controller中的ResquestMapping
//feign类似于http客户端
//configuration = FeignRequestConfiguration.class是为了配置拦截器在请求头中加token
@FeignClient(value = "business-shift", path = "shift/type", configuration = FeignRequestConfiguration.class, fallback = ShiftTypeFeignFallback.class)
public interface ShiftTypeFeign {
    /**
     * 获取排班分类
     *
     * @return
     */
    @GetMapping(value = "info")
    String info();

    /**
     * 新增排班分类
     * @param shiftTypeParam
     * @return
     */
    @PostMapping(value = "add")
    String add(@RequestBody ShiftTypeParam shiftTypeParam);


    /**
     * 修改排班分类
     * @param shiftTypeDTO
     * @return
     */
    @PostMapping(value = "update")
    String update(@RequestBody ShiftTypeDTO shiftTypeDTO);

    /**
     * 删除排班分类
     *
     * @param id
     * @return
     */
    @PostMapping(value = "delete")
    String delete(@RequestBody Long id);


}

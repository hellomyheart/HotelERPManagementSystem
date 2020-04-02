package com.demo.hotel.business.feign.fallback;

import com.demo.hotel.commons.dto.ResponseResult;
import com.demo.hotel.commons.utils.MapperUtils;

/**
 * @program: HotelERPManagementSystem
 * @description: 公共FeignFallback类
 * @author: syj
 * @create: 2020-04-02 14:23
 **/
public  class CommonsFeignFallback<T> {



    public String Message(Integer status, FeignFallbackMessage fallbackMessage, T data) {
        try {
            return MapperUtils.obj2json(new ResponseResult<T>(status, fallbackMessage.getMessage(),data));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public  String Message(Integer status, FeignFallbackMessage fallbackMessage) {
        try {
            return MapperUtils.obj2json(new ResponseResult<Void>(status,fallbackMessage.getMessage()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

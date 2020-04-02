package com.demo.hotel.business.controller.fallback;


import com.demo.hotel.commons.dto.ResponseResult;

/**
 * @program: HotelERPManagementSystem
 * @description: CommonsFallback
 * @author: syj
 * @create: 2020-04-02 16:05
 **/
public class CommonsFallback<T> {
    public ResponseResult<T> returnResponseResult(int status, FallbackMessage fallbackMessage, T data) {
        return new ResponseResult<T>(status, fallbackMessage.getMessage(), data);
    }
}
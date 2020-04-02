package com.demo.hotel.business.feign.fallback;

/**
 * @program: HotelERPManagementSystem
 * @description: FallbackMessage
 * @author: syj
 * @create: 2020-04-02 14:39
 **/
public enum FeignFallbackMessage {

    //请求失败，简单信息
    BREAKING_MESSAGE("请求失败了，请检查您的网络");

    private String message="";
    FeignFallbackMessage(String value){
        message=value;
    }

    public String getMessage(){
        return message;
    }

}
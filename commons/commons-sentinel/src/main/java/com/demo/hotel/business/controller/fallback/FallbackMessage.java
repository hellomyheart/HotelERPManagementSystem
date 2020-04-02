package com.demo.hotel.business.controller.fallback;

/**
 * @program: HotelERPManagementSystem
 * @description: FallbackMessage
 * @author: syj
 * @create: 2020-04-02 16:07
 **/
public enum  FallbackMessage {

    //请求失败，简单信息
    BREAKING_MESSAGE("请求失败了，请检查您的网络");

    private String message="";
    FallbackMessage(String value){
        message=value;
    }

    public String getMessage(){
        return message;
    }

}
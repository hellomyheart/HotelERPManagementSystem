package com.demo.hotel.provider.api;


/**
 * @program: HotelERPManagementSystem
 * @description:
 * @author: syj
 * @create: 2020-04-20 06:49
 **/
public interface SendSmsService {
    /**
     * 发送验证码
     * @param phoneNumber
     * @param code
     * @return
     */
    boolean sendCode(String phoneNumber,String code);
}

package com.demo.hotel.cloud.message;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @program: HotelERPManagementSystem
 * @description: 消息数据
 * @author: syj
 * @create: 2020-03-31 22:29
 **/
public interface MessageSource {
    @Output("admin-login-log-topic")
    MessageChannel adminLoginLog();
}

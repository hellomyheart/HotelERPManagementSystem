package com.demo.hotel.message.sink;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface UserCodeSink {

    /**
     * 用户注册验证码主题
     * @return
     */
    @Input("user-code-topic")
    SubscribableChannel userCode();

}

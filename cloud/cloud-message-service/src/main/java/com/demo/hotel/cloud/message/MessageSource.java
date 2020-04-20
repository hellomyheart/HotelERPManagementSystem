package com.demo.hotel.cloud.message;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author syj
 */
public interface MessageSource {

    /**
     * 登录日志主题
     * @return
     */
    @Output("admin-login-log-topic")
    MessageChannel adminLoginLog();

    /**
     * 注册验证码主题
     * @return
     */
    @Output("user-code-topic")
    MessageChannel userCode();
}

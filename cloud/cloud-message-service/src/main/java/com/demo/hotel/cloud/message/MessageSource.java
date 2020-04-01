package com.demo.hotel.cloud.message;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author syj
 */
public interface MessageSource {

    @Output("admin-login-log-topic")
    MessageChannel adminLoginLog();

}

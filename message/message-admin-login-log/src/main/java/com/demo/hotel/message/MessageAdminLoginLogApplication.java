package com.demo.hotel.message;

import com.demo.hotel.message.sink.AdminLoginLogSink;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding({AdminLoginLogSink.class})
public class MessageAdminLoginLogApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessageAdminLoginLogApplication.class, args);
    }

}

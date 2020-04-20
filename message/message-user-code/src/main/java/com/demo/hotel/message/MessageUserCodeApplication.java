package com.demo.hotel.message;

import com.demo.hotel.message.sink.UserCodeSink;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding({UserCodeSink.class})
public class MessageUserCodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessageUserCodeApplication.class, args);
    }

}

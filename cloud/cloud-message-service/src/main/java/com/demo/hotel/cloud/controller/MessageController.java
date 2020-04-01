package com.demo.hotel.cloud.controller;

import com.demo.hotel.cloud.producer.MessageProducer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "message")
public class MessageController {

    @Resource
    private MessageProducer messageProducer;
}

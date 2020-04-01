package com.demo.hotel.cloud.controller;

import com.demo.hotel.cloud.producer.MessageProducer;

import javax.annotation.Resource;

/**
 * @program: HotelERPManagementSystem
 * @description: 消息控制器
 * @author: syj
 * @create: 2020-03-31 22:32
 **/
public class MessageController {
    @Resource
    private MessageProducer messageProducer;

}

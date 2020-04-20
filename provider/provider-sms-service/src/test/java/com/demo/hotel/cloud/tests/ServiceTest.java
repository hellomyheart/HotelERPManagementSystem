package com.demo.hotel.cloud.tests;

import com.demo.hotel.provider.api.SendSmsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @program: HotelERPManagementSystem
 * @description:
 * @author: syj
 * @create: 2020-04-20 07:00
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {
    @Resource
    private SendSmsService sendSmsService;

    @Test
    public void SendSmsTest() {
        sendSmsService.sendCode("15555555555","95588");
    }
}

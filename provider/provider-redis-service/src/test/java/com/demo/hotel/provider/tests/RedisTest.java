package com.demo.hotel.provider.tests;

import com.demo.hotel.provider.api.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @program: HotelERPManagementSystem
 * @description:
 * @author: syj
 * @create: 2020-04-19 17:19
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Resource
    RedisService redisService;

    @Test
    public void insertTest(){
        redisService.insert("cs测试55c","测试558j");
    }

    @Test
    public void getTest(){
        System.out.println(redisService.get("cs测试55c"));
    }
}

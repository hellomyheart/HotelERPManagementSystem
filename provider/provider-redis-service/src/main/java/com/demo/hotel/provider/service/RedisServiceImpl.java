package com.demo.hotel.provider.service;

import com.demo.hotel.provider.api.RedisService;
import org.apache.dubbo.config.annotation.Service;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;

/**
 * @program: HotelERPManagementSystem
 * @description:
 * @author: syj
 * @create: 2020-04-19 17:07
 **/
@Service(version = "1.0.0")
public class RedisServiceImpl implements RedisService {

    @Resource
    private Jedis jedis;

    @Override
    public void insert(String key, String content) {
        //存值
        jedis.set(key, content);
    }

    @Override
    public String get(String key) {
        //存值
        return jedis.get(key);
    }
}

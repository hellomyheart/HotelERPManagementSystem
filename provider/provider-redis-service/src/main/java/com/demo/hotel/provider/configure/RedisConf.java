package com.demo.hotel.provider.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

/**
 * @program: HotelERPManagementSystem
 * @description:
 * @author: syj
 * @create: 2020-04-19 17:09
 **/
@Configuration
public class RedisConf {
    @Bean
    public Jedis jedis(){ return new Jedis("192.168.141.200", 6379);}
}

package com.demo.hotel.provider;

import com.demo.hotel.configuration.DubboSentinelConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: HotelERPManagementSystem
 * @description:
 * @author: syj
 * @create: 2020-04-19 17:04
 **/
@SpringBootApplication(scanBasePackageClasses = {ProviderRedisApplication.class, DubboSentinelConfiguration.class})
public class ProviderRedisApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderRedisApplication.class,args);
    }
}

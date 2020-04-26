package com.demo.hotel.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: HotelERPManagementSystem
 * @description: Appplication
 * @author: syj
 * @create: 2020-03-30 13:50
 **/
//开启服务发现
@SpringBootApplication
@EnableDiscoveryClient
public class BusinessUserProfileApplication {
    public static void main(String[] args) {
        SpringApplication.run(BusinessUserProfileApplication.class,args);
    }
}

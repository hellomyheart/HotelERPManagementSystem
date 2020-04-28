package com.demo.hotel.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: HotelERPManagementSystem
 * @description:
 * @author: syj
 * @create: 2020-04-03 16:34
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class BusinessRestaurantInventoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(BusinessRestaurantInventoryApplication.class,args);
    }
}

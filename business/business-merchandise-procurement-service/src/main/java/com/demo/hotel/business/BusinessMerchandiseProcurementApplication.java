package com.demo.hotel.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: HotelERPManagementSystem
 * @description: Organization入口
 * @author: syj
 * @create: 2020-04-03 16:34
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class BusinessMerchandiseProcurementApplication {
    public static void main(String[] args) {
        SpringApplication.run(BusinessMerchandiseProcurementApplication.class,args);
    }
}

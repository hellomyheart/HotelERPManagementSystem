package com.demo.hotel.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author syj
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class BusinessAdminOAuth2Application {
    public static void main(String[] args) {
        SpringApplication.run(BusinessAdminOAuth2Application.class, args);
    }
}

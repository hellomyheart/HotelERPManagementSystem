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
//@SpringBootApplication(scanBasePackageClasses = {BusinessUserOAuth2Application.class}, scanBasePackages = "com.demo.hotel.cloud.feign")
@SpringBootApplication(scanBasePackageClasses = {BusinessUserOAuth2Application.class})
public class BusinessUserOAuth2Application {
    public static void main(String[] args) {
        SpringApplication.run(BusinessUserOAuth2Application.class, args);
    }
}

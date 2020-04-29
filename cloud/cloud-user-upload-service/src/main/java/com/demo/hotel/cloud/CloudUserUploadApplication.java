package com.demo.hotel.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: HotelERPManagementSystem
 * @description: 文件上传服务
 * @author: syj
 * @create: 2020-03-31 12:37
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class CloudUserUploadApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudUserUploadApplication.class, args);
    }

}

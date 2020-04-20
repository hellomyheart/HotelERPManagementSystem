package com.demo.hotel.provider;

import com.demo.hotel.configuration.DubboSentinelConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @program: HotelERPManagementSystem
 * @description:
 * @author: syj
 * @create: 2020-04-20 18:39
 **/
@SpringBootApplication(scanBasePackageClasses = {ProviderUserApplication.class, DubboSentinelConfiguration.class})
@MapperScan(basePackages = "com.demo.hotel.provider.mapper")
public class ProviderUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderUserApplication.class,args);
    }
}

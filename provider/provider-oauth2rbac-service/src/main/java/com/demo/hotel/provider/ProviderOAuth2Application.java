package com.demo.hotel.provider;

import com.demo.hotel.configuration.DubboSentinelConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @program: HotelERPManagementSystem
 * @description: ProviderOAuth2Application
 * @author: syj
 * @create: 2020-04-02 19:53
 **/
@SpringBootApplication(scanBasePackageClasses = {ProviderOAuth2Application.class, DubboSentinelConfiguration.class})
@MapperScan(basePackages = "com.demo.hotel.provider.mapper")
public class ProviderOAuth2Application {
    public static void main(String[] args) {
        SpringApplication.run(ProviderOAuth2Application.class,args);
    }
}

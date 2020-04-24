package com.demo.hotel.provider;

import com.demo.hotel.configuration.DubboSentinelConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @program: HotelERPManagementSystem
 * @description: ProviderTrainingApplication
 * @author: syj
 * @create: 2020-04-06 21:20
 **/
@SpringBootApplication(scanBasePackageClasses = {ProviderCashApplication.class, DubboSentinelConfiguration.class})
@MapperScan(basePackages = "com.demo.hotel.provider.mapper")
public class ProviderCashApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderCashApplication.class, args);
    }

}

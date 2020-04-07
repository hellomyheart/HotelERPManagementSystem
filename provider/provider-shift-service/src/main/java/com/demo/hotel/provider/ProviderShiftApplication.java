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
@SpringBootApplication(scanBasePackageClasses = {ProviderShiftApplication.class, DubboSentinelConfiguration.class})
@MapperScan(basePackages = "com.demo.hotel.provider.mapper")
public class ProviderShiftApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderShiftApplication.class, args);
    }

}

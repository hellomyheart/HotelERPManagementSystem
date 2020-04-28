package com.demo.hotel.provider;

import com.demo.hotel.configuration.DubboSentinelConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @program: HotelERPManagementSystem
 * @description:
 * @author: syj
 * @create: 2020-04-03 13:03
 **/

@SpringBootApplication(scanBasePackageClasses = {ProviderCleaningInventoryApplication.class, DubboSentinelConfiguration.class})
@MapperScan(basePackages = "com.demo.hotel.provider.mapper")
public class ProviderCleaningInventoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderCleaningInventoryApplication.class,args);
    }

}

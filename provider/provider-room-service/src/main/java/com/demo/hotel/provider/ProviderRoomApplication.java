package com.demo.hotel.provider;

import com.demo.hotel.configuration.DubboSentinelConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @program: HotelERPManagementSystem
 * @description: ProviderOrganizationApplication
 * @author: syj
 * @create: 2020-04-03 13:03
 **/

@SpringBootApplication(scanBasePackageClasses = {ProviderRoomApplication.class, DubboSentinelConfiguration.class})
@MapperScan(basePackages = "com.demo.hotel.provider.mapper")
public class ProviderRoomApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderRoomApplication.class,args);
    }

}

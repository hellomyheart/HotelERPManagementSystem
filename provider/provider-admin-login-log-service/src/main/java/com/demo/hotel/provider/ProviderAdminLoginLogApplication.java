package com.demo.hotel.provider;

import com.demo.hotel.configuration.DubboSentinelConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @program: HotelERPManagementSystem
 * @description: admin登录日志服务provider实现
 * @author: syj
 * @create: 2020-03-31 21:27
 **/
@SpringBootApplication(scanBasePackageClasses = {ProviderAdminLoginLogApplication.class, DubboSentinelConfiguration.class})
@MapperScan(basePackages = "com.demo.hotel.provider.mapper")
public class ProviderAdminLoginLogApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderAdminLoginLogApplication.class,args);
    }
}

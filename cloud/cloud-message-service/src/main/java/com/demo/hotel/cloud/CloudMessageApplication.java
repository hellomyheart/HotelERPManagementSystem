package com.demo.hotel.cloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import com.demo.hotel.cloud.message.MessageSource;
/**
 * @program: HotelERPManagementSystem
 * @description: 消息服务service
 * @author: syj
 * @create: 2020-03-31 22:26
 **/

@SpringBootApplication
@EnableDiscoveryClient
@EnableBinding({MessageSource.class})
public class CloudMessageApplication {
}

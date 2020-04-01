package com.demo.hotel.cloud.tests;

import com.demo.hotel.cloud.dto.AdminLoginLogDTO;
import com.demo.hotel.commons.utils.MapperUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @program: HotelERPManagementSystem
 * @description: 消息测试类
 * @author: syj
 * @create: 2020-03-31 22:46
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageCloudTests {

    @Test
    public void testPrintln() throws Exception {
        AdminLoginLogDTO dto = new AdminLoginLogDTO();
        dto.setAdminId(1L);
        dto.setCreateTime(new Date());
        dto.setIp("0.0.0.0");
        dto.setAddress("0.0.0.0");
        dto.setUserAgent("0.0.0.0");
        System.out.println(MapperUtils.obj2json(dto));
    }
}

package com.demo.hotel.cloud.tests;
import java.util.Date;

import com.demo.hotel.cloud.dto.AdminLoginLogDTO;
import com.demo.hotel.commons.utils.MapperUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

package com.demo.hotel.business.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: HotelERPManagementSystem
 * @description: OAuth2测试类
 * @author: syj
 * @create: 2020-03-29 09:34
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessAdminOAuth2Tests {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Test
    public void testPasswordEncoder() {
        System.out.println(passwordEncoder.encode("secret"));
    }

}

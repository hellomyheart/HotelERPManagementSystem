package com.demo.hotel.provider.tests;

import com.demo.hotel.provider.api.UsersService;
import com.demo.hotel.provider.domain.Users;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @program: HotelERPManagementSystem
 * @description:
 * @author: syj
 * @create: 2020-04-20 19:05
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback
@Transactional
public class UserServiceTest {

    @Resource
    private UsersService usersService;

    //Hash算法
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Test
    public void insertTest() {
        Users users = new Users();
        users.setUsername("test01");
        users.setIdentify("555566661111222233");
        users.setNickname("testnickname");
        users.setPhone("15555555555");
        users.setPassword(passwordEncoder.encode("123456"));
        users.setCreatTime(new Date());
        users.setUpdateTime(new Date());
        users.setIcon("sdsd");
        users.setGender(0);
        users.setName2("张三");
        users.setPhone2("16666666666");
        usersService.insert(users);
    }

    @Test
    public void getTest() {
        System.out.println(usersService.get(1L));
    }

    @Test
    public void updateTest() {
        Users users = usersService.get(1L);
        users.setNickname("55662");
        users.setGender(5);
        int update = usersService.update(users);
        Assert.assertEquals(1, update);
    }

    @Test
    public void modifyPassword() {
        int i = usersService.modifyPassword(1L, "123");
        Assert.assertEquals(1, i);
    }

    @Test
    public void modifyIcon() {
        int i = usersService.modifyIcon(1L, "123456sdsd");
        Assert.assertEquals(1, i);
    }
}

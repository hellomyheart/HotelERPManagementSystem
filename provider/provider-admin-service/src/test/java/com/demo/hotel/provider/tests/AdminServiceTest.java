package com.demo.hotel.provider.tests;

import java.util.Date;

import com.demo.hotel.provider.api.AdminService;
import com.demo.hotel.provider.domain.Admin;
import com.demo.hotel.provider.mapper.AdminMapper;
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
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class AdminServiceTest {

    @Autowired
    private AdminMapper adminMapper;

    @Resource
    private AdminService adminService;

    //Hash算法
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Test
    public void testSelectAll() {
        List<Admin> admins = adminMapper.selectAll();
        admins.forEach(admin -> {
            System.out.println(admin);
        });

    }

    @Test
    public void testSelectOne() {
        Admin admin = adminService.get(1L);
        System.out.println(admin);
    }

    @Test
    public void testInsert() {
        Admin admin = new Admin();
        admin.setUsername("test");
        admin.setEmployeeId(112L);
        admin.setEmail("test@test.com");
        admin.setPassword(passwordEncoder.encode("123456"));
        admin.setPhone("15656565656");
        admin.setCreateTime(new Date());
        admin.setUpdateTime(new Date());
        admin.setIcon("/sdsd");
        admin.setGender(1);

        int result = adminService.insert(admin);
        Assert.assertEquals(result, 1);
    }

    @Test
    public void testUpdate() {
        Admin admin = adminService.get(1L);

        admin.setUsername("test2");
        admin.setPhone("15252525252");
        admin.setUpdateTime(new Date());
        admin.setIcon("test");
        admin.setGender(2);
        int result = adminService.update(admin);
        Assert.assertEquals(result, 1);
    }

    @Test
    public void testDelete() {
        int result = adminService.delete("er");
        Assert.assertEquals(result, 1);
    }

}

package com.demo.hotel.provider.tests;
import java.util.Date;

import com.demo.hotel.provider.api.AdminLoginLogService;
import com.demo.hotel.provider.domain.AdminLoginLog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @program: HotelERPManagementSystem
 * @description: AdminLoginLog测试类
 * @author: syj
 * @create: 2020-03-31 21:41
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class AdminLoginLogTests {
    @Resource
    private AdminLoginLogService adminLoginLogService;
    @Test
    public void testInsert(){
        AdminLoginLog adminLoginLog=new AdminLoginLog();
        adminLoginLog.setAdminId(12L);
        adminLoginLog.setCreateTime(new Date());
        adminLoginLog.setIp("4523");
        adminLoginLog.setAddress("846");
        adminLoginLog.setUserAgent("511132");
        adminLoginLogService.insert(adminLoginLog);

    }
}

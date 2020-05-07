package com.demo.hotel.provider.tests;
import java.util.Date;

import com.demo.hotel.provider.api.SalaryEService;
import com.demo.hotel.provider.api.SalaryService;
import com.demo.hotel.provider.domain.Salary;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @program: HotelERPManagementSystem
 * @description: Department测试类
 * @author: syj
 * @create: 2020-04-06 14:48
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class SalaryTests {
    @Resource
    SalaryService service;

    @Resource
    SalaryEService vService;
    @Test
    public void insertTest(){
        Salary domain=new Salary();
        domain.setCreatDate(new Date());
        domain.setEmployeeId(2L);
        domain.setReale(200D);
        Assert.assertEquals(service.insert(domain),1);

    }

    @Test
    public void deleteTest(){
        Assert.assertEquals(service.delete(3L),1);
    }


    @Test
    public void selectAllTest(){
        System.out.println(vService.selectAll());
    }

}

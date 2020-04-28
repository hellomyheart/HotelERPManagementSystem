package com.demo.hotel.provider.tests;


import com.demo.hotel.provider.api.CleaningService;
import com.demo.hotel.provider.domain.Cleaning;
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
public class CleaningTests {
    @Resource
    CleaningService cleaningService;


    @Test
    public void updateTest(){
        Cleaning cleaning = cleaningService.selectAll().get(0);
        cleaning.setId(1L);
        cleaning.setNote("不应该修改");
        cleaning.setCleaningNumber(55D);
        Assert.assertEquals(cleaningService.update(cleaning),1);
    }

    @Test
    public void selectAllTest(){
        System.out.println(cleaningService.selectAll());
    }

}

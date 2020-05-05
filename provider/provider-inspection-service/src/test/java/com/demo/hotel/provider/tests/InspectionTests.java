package com.demo.hotel.provider.tests;
import java.util.Date;

import com.demo.hotel.provider.api.InspectionService;
import com.demo.hotel.provider.domain.Inspection;
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
public class InspectionTests {
    @Resource
    InspectionService service;

    @Test
    public void insertTest(){
        Inspection inspection=new Inspection();
        inspection.setRoomId(5L);
        inspection.setInspectionTime(new Date());
        inspection.setNote("");
        int insert = service.insert(inspection);
        Assert.assertEquals(insert,1);
    }

    @Test
    public void deleteTest(){
        Assert.assertEquals(service.delete(3L),1);
    }

    @Test
    public void updateTest(){
        Inspection inspection = service.selectAll().get(0);
        inspection.setRoomId(2L);
        inspection.setInspectionTime(new Date());
        inspection.setNote("");

        Assert.assertEquals(service.update(inspection),1);
    }

    @Test
    public void selectAllTest(){
        System.out.println(service.selectAll());
    }

}

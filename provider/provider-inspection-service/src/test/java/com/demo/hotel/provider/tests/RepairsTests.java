package com.demo.hotel.provider.tests;

import com.demo.hotel.provider.api.RepairsService;
import com.demo.hotel.provider.domain.Repairs;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

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
public class RepairsTests {
    @Resource
    RepairsService service;

    @Test
    public void insertTest(){
        Repairs repairs=new Repairs();
        repairs.setRoomId(5L);
        repairs.setRepairsTime(new Date());
        repairs.setStatus(0);


        int insert = service.insert(repairs);
        Assert.assertEquals(insert,1);
    }

    @Test
    public void deleteTest(){
        Assert.assertEquals(service.delete(2L),1);
    }

    @Test
    public void updateTest(){
        Repairs repairs = service.selectAll().get(0);
        repairs.setRoomId(8L);
        repairs.setRepairsTime(new Date());
        repairs.setStatus(1);
        repairs.setNote("");

        Assert.assertEquals(service.update(repairs),1);
    }

    @Test
    public void selectAllTest(){
        System.out.println(service.selectAll());
    }

}

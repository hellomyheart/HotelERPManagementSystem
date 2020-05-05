package com.demo.hotel.provider.tests;

import com.demo.hotel.provider.api.PositionDService;
import com.demo.hotel.provider.api.PositionService;
import com.demo.hotel.provider.domain.Position;
import com.demo.hotel.provider.domain.PositionD;
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
 * @description: Position测试类
 * @author: syj
 * @create: 2020-04-06 16:43
 **/


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class PositionTests {
    @Resource
    public PositionService positionService;

    @Resource
    public PositionDService positionDService;

    @Test
    public void insertTest() {
        Position position = new Position();
        position.setDepartmentId(3L);
        position.setPositionName("测试职位名");
        position.setBasesalary(500D);
        position.setBaseTime(10D);
        int insert = positionService.insert(position);
        Assert.assertEquals(insert, 1);
    }

    @Test
    public void deleteTest() {
        int delete = positionService.delete(3L);
        Assert.assertEquals(delete, 1);
    }

    @Test
    public void updateTest() {
        Position position=new Position();
        position.setId(3L);
        position.setDepartmentId(3L);
        position.setPositionName("testd的");
        position.setBasesalary(0.0D);
        position.setBaseTime(0.0D);


        int update = positionService.update(position);
        Assert.assertEquals(update, 1);
    }

    @Test
    public void selectAllTest(){
        System.out.println(positionDService.selectAll());

    }

}

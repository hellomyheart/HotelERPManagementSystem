package com.demo.hotel.provider.tests;

import com.demo.hotel.provider.api.ShiftTypeDService;
import com.demo.hotel.provider.api.ShiftTypeService;
import com.demo.hotel.provider.domain.ShiftType;
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
 * @description: 排班分类测试类
 * @author: syj
 * @create: 2020-04-06 14:48
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class ShiftTypeTests {


    @Resource
    ShiftTypeService shiftTypeService;

    @Resource
    ShiftTypeDService shiftTypeDService;

    @Test
    public void insertTest() {
        ShiftType shiftType = new ShiftType();

        shiftType.setTypeName("2班排班");
        shiftType.setDepartmentId(5L);
        Assert.assertEquals(shiftTypeService.insert(shiftType), 1);
    }

    @Test
    public void deleteTest() {
        Assert.assertEquals(shiftTypeService.delete(2L), 1);
    }

    @Test
    public void updateTest() {
        ShiftType shiftType = new ShiftType();
        shiftType.setId(3L);
        shiftType.setTypeName("3班排班");
        shiftType.setDepartmentId(6L);


        Assert.assertEquals(shiftTypeService.update(shiftType), 1);
    }

    @Test
    public void selectAllTest() {
        System.out.println(shiftTypeDService.selectAll());
    }
}

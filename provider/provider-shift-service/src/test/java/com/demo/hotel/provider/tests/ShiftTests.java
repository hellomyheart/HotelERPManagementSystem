package com.demo.hotel.provider.tests;

import java.time.LocalTime;
import java.util.Date;

import com.demo.hotel.provider.api.ShiftService;
import com.demo.hotel.provider.api.ShiftTService;
import com.demo.hotel.provider.api.ShiftTypeDService;
import com.demo.hotel.provider.api.ShiftTypeService;
import com.demo.hotel.provider.domain.Shift;
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
public class ShiftTests {

    @Resource
    ShiftService shiftService;

    @Resource
    ShiftTService shiftTService;

    @Test
    public void insertTest() {
        Shift shift = new Shift();
        shift.setTitle("test");
        shift.setTypeId(3L);
        LocalTime l=LocalTime.of(8,8,8);
        shift.setStartTime(l);
        shift.setEndTime(l);
        shift.setTimes(3);

        Assert.assertEquals(shiftService.insert(shift), 1);
    }

    @Test
    public void deleteTest() {
        Assert.assertEquals(shiftService.delete(2L), 1);
    }

    @Test
    public void updateTest() {
        Shift shift = new Shift();
        shift.setId(2L);
        shift.setTypeId(2L);
        LocalTime localTime=LocalTime.of(8,8,8);
        shift.setStartTime(localTime);
        shift.setEndTime(localTime);
        shift.setTimes(5);



        Assert.assertEquals(shiftService.update(shift), 1);
    }

    @Test
    public void selectAllTest() {
        System.out.println(shiftTService.selectAll());
    }
}

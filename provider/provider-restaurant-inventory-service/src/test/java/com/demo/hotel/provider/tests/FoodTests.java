package com.demo.hotel.provider.tests;


import com.demo.hotel.provider.api.FoodService;
import com.demo.hotel.provider.domain.Food;
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
public class FoodTests {
    @Resource
    FoodService foodService;


    @Test
    public void updateTest(){
        Food food = foodService.selectAll().get(0);
        food.setId(1L);
        food.setNote("不应该修改");
        food.setFoodNumber(56);
        Assert.assertEquals(foodService.update(food),1);
    }

    @Test
    public void selectAllTest(){
        System.out.println(foodService.selectAll());
    }

}

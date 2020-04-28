package com.demo.hotel.provider.tests;

import com.demo.hotel.provider.api.GoodsService;
import com.demo.hotel.provider.domain.Goods;
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
public class GoodsTests {
    @Resource
    GoodsService goodsService;


    @Test
    public void updateTest(){
        Goods goods = goodsService.selectAll().get(0);
        goods.setGoodsSum(500D);
        goods.setGoodsName("不应该修改");
        Assert.assertEquals(goodsService.update(goods),1);
    }

    @Test
    public void selectAllTest(){
        System.out.println(goodsService.selectAll());
    }

}

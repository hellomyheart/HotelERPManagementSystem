package com.demo.hotel.provider.tests;

import com.demo.hotel.provider.api.CashFlowService;
import com.demo.hotel.provider.domain.CashFlow;
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
 * @description:
 * @author: syj
 * @create: 2020-04-24 17:48
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class CashFlowTests {
    @Resource
    CashFlowService cashFlowService;

    @Test
    public void insertTest(){
        CashFlow cashFlow=new CashFlow();
        cashFlow.setFlowType(1);
        cashFlow.setMoney(100D);
        cashFlow.setNote("入账1800");


        Assert.assertEquals(cashFlowService.insert(cashFlow),1);
    }

    @Test
    public void deleteTest(){
        Assert.assertEquals(cashFlowService.delete(3L),1);
    }


    @Test
    public void selectAllTest(){
        System.out.println(cashFlowService.selectAll());
    }

}

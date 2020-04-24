package com.demo.hotel.provider.tests;
import java.util.Date;

import com.demo.hotel.provider.api.CashApplyEService;
import com.demo.hotel.provider.api.CashApplyService;
import com.demo.hotel.provider.domain.CashApply;
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
public class CashApplyTests {
    @Resource
    CashApplyService cashApplyService;
    @Resource
    CashApplyEService cashApplyEService;

    @Test
    public void insertTest(){
        CashApply cashApply=new CashApply();
        cashApply.setTitle("test1");
        cashApply.setCreateTime(new Date());
        cashApply.setPrice(0.0D);
        cashApply.setNote("test");
        cashApply.setApplyId(1L);
        cashApply.setStatus(0);

        Assert.assertEquals(cashApplyService.insert(cashApply),1);
    }

    @Test
    public void deleteTest(){
        Assert.assertEquals(cashApplyService.delete(2L),1);
    }

    @Test
    public void updateTest(){
        CashApply cashApply=new CashApply();
        cashApply.setId(1L);
        cashApply.setTitle("test5");
        cashApply.setCreateTime(new Date());
        cashApply.setPrice(5.0D);
        cashApply.setNote("ss");
        cashApply.setApplyId(1L);
        cashApply.setStatus(0);

        Assert.assertEquals(cashApplyService.update(cashApply),1);
    }

    @Test
    public void selectAllTest(){
        System.out.println(cashApplyEService.selectAll());
    }

}

package com.demo.hotel.provider.tests;
import java.util.Date;

import com.demo.hotel.provider.api.FacilityApplyEService;
import com.demo.hotel.provider.api.FacilityApplyService;
import com.demo.hotel.provider.domain.FacilityApply;
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
public class FacilityTests {
    @Resource
    FacilityApplyService facilityApplyService;
    @Resource
    FacilityApplyEService facilityApplyEService;

    @Test
    public void insertTest(){
        FacilityApply facilityApply=new FacilityApply();
        facilityApply.setTitle("test");
        facilityApply.setCreateTime(new Date());
        facilityApply.setPrice(2.0D);
        facilityApply.setUnit("个");
        facilityApply.setQuantity(5.0D);
        facilityApply.setTotalPrice(5.0D);
        facilityApply.setNote("d");
        facilityApply.setApplyId(1L);
        facilityApply.setStatus(0);


        Assert.assertEquals(facilityApplyService.insert(facilityApply),1);
    }

    @Test
    public void deleteTest(){
        Assert.assertEquals(facilityApplyService.delete(3L),1);
    }

    @Test
    public void updateTest(){
        FacilityApply facilityApply=new FacilityApply();
        facilityApply.setId(2L);
        facilityApply.setTitle("testupdate");
        facilityApply.setCreateTime(new Date());
        facilityApply.setPrice(2.0D);
        facilityApply.setUnit("个");
        facilityApply.setQuantity(5.0D);
        facilityApply.setTotalPrice(5.0D);
        facilityApply.setNote("d");
        facilityApply.setApplyId(1L);
        facilityApply.setStatus(0);
        Assert.assertEquals(facilityApplyService.update(facilityApply),1);
    }

    @Test
    public void selectAllTest(){
        System.out.println(facilityApplyEService.selectAll());
    }

}

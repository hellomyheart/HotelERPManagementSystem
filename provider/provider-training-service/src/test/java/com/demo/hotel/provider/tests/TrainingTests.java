package com.demo.hotel.provider.tests;
import java.util.Date;

import com.demo.hotel.provider.api.TrainingEcService;
import com.demo.hotel.provider.api.TrainingService;
import com.demo.hotel.provider.domain.Training;
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
 * @description: Training测试类
 * @author: syj
 * @create: 2020-04-06 14:48
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class TrainingTests {
    @Resource
    TrainingService trainingService;

    @Resource
    TrainingEcService trainingEcService;

//    @Test
//    public void insertTest(){
//        Training training=new Training();
//        training.setEmployeeId(2L);
//        training.setTrainingContentId(2L);
//        training.setCreateTime(new Date());
//        training.setEndTime(new Date());
//
//
//        Assert.assertEquals(trainingService.insert(training),1);
//    }
//
//    @Test
//    public void deleteTest(){
//        Assert.assertEquals(trainingService.delete(3L),1);
//    }
//
//    @Test
//    public void updateTest(){
//        Training training=new Training();
//        training.setId(1L);
//        training.setEmployeeId(2L);
//        training.setTrainingContentId(5L);
//        training.setCreateTime(new Date());
//        training.setEndTime(new Date());
//        Assert.assertEquals(trainingService.update(training),1);
//    }
//
//    @Test
//    public void selectAllTest(){
//        System.out.println(trainingEcService.selectAll());
//    }

}

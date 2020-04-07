package com.demo.hotel.provider.tests;
import java.util.Date;

import com.demo.hotel.provider.api.TrainingContentPService;
import com.demo.hotel.provider.api.TrainingContentService;
import com.demo.hotel.provider.domain.TrainingContent;
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
 * @description:  TrainingContent测试类
 * @author: syj
 * @create: 2020-04-06 14:48
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class TrainingContentTests {
    @Resource
    TrainingContentService trainingContentService;

    @Resource
    TrainingContentPService trainingContentPService;

    @Test
    public void insertTest(){

        TrainingContent trainingContent=new TrainingContent();

        trainingContent.setPositionId(3L);
        trainingContent.setTitle("测试标题");
        trainingContent.setNote("cs测试");
        trainingContent.setSumTime(2);
        trainingContent.setCreateTime(new Date());



        Assert.assertEquals(trainingContentService.insert(trainingContent),1);
    }

    @Test
    public void deleteTest(){
        Assert.assertEquals(trainingContentService.delete(2L),1);
    }

    @Test
    public void updateTest(){
        TrainingContent trainingContent=new TrainingContent();
        trainingContent.setId(2L);
        trainingContent.setPositionId(3L);
        trainingContent.setTitle("5cs测试5556");
        trainingContent.setNote("666");
        trainingContent.setSumTime(0);
        trainingContent.setCreateTime(new Date());

        Assert.assertEquals(trainingContentService.update(trainingContent),1);
    }

    @Test
    public void selectAllTest(){
        System.out.println(trainingContentPService.selectAll());
    }

    @Test
    public void searchByIDTest(){
        System.out.println(trainingContentService.searchByID(3L));
    }

}

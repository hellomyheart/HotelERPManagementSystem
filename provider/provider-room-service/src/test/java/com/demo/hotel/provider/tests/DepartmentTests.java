package com.demo.hotel.provider.tests;

import com.demo.hotel.provider.api.DepartmentService;
import com.demo.hotel.provider.domain.Department;
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
public class DepartmentTests {
    @Resource
    DepartmentService departmentService;

    @Test
    public void insertTest(){
        Department department=new Department();
        department.setDepartmentName("test");
        department.setNote("test测试");

        Assert.assertEquals(departmentService.insert(department),1);
    }

    @Test
    public void deleteTest(){
        Assert.assertEquals(departmentService.delete(3L),1);
    }

    @Test
    public void updateTest(){
        Department department=departmentService.selectAll().get(0);
        department.setDepartmentName("test2");
        department.setNote("test测试2");
        Assert.assertEquals(departmentService.update(department),1);
    }

    @Test
    public void selectAllTest(){
        System.out.println(departmentService.selectAll());
    }

}

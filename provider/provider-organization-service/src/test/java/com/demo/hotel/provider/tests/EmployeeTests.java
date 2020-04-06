package com.demo.hotel.provider.tests;
import java.util.Date;

import com.demo.hotel.provider.api.EmployeePService;
import com.demo.hotel.provider.api.EmployeeService;
import com.demo.hotel.provider.domain.Employee;
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
 * @description: Employee测试类
 * @author: syj
 * @create: 2020-04-06 18:46
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class EmployeeTests {
    @Resource
    EmployeeService employeeService;

    @Resource
    EmployeePService employeePService;

    @Test
    public void insertTest(){
        Employee employee=new Employee();
        employee.setPositionId(1L);
        employee.setEmployeeName("测试employee");
        employee.setIdentify("111");
        employee.setPhone("1111");
        employee.setCreateTime(new Date());
        employee.setUpdateTime(new Date());
        employee.setGender(0);
        employee.setBirthday(new Date());
        int insert = employeeService.insert(employee);
        Assert.assertEquals(insert,1);
    }

    @Test
    public void deleteTest() {
        int delete = employeeService.delete(2L);
        Assert.assertEquals(delete, 1);
    }

    @Test
    public void updateTest() {
        Employee employee=new Employee();
        employee.setId(2L);
        employee.setPositionId(1L);
        employee.setEmployeeName("测试employee22");
        employee.setIdentify("111");
        employee.setPhone("1111");
        employee.setCreateTime(new Date());
        employee.setUpdateTime(new Date());
        employee.setGender(0);
        employee.setBirthday(new Date());


        int update = employeeService.update(employee);
        Assert.assertEquals(update, 1);
    }

    @Test
    public void selectAllTest(){
        System.out.println(employeePService.selectAll());

    }


}

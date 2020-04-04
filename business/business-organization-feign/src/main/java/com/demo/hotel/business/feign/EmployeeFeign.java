package com.demo.hotel.business.feign;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @program: HotelERPManagementSystem
 * @description: 职工Feign
 * @author: syj
 * @create: 2020-04-03 16:11
 **/
public interface EmployeeFeign {

    //TODO 待修改
    static final String EMPLOYMENT_URL = "employee/";

}

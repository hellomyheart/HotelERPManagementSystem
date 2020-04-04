package com.demo.hotel.business.feign;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @program: HotelERPManagementSystem
 * @description: 职位feign
 * @author: syj
 * @create: 2020-04-03 16:19
 **/
public interface PositionFeign {

    //TODO 待修改
    static final String POSITION_URL = "position/";

}
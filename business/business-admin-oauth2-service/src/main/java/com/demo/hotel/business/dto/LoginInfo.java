package com.demo.hotel.business.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: HotelERPManagementSystem
 * @description: 登录信息dto
 * @author: syj
 * @create: 2020-03-29 18:02
 **/
@Data
public class LoginInfo implements Serializable {
    private String name;
    private String avatar;
    private String nickname;
}
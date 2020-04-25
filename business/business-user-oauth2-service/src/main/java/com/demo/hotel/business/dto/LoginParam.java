package com.demo.hotel.business.dto;

import lombok.Data;

import java.io.Serializable;

/**
* @Description: 登录dto
* @Author: syj
* @Date: 2020/3/28
*/
@Data
public class LoginParam implements Serializable {

    private String username;
    private String password;
}

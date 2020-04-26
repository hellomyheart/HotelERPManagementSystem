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


    private static final long serialVersionUID = -246920634529618754L;
    private String username;
    private String password;
}

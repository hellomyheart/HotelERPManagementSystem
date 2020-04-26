package com.demo.hotel.business.dto.params;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: HotelERPManagementSystem
 * @description: 修改密码参数
 * @author: syj
 * @create: 2020-03-30 14:20
 **/
@Data
public class PasswordParam implements Serializable {


    private static final long serialVersionUID = -3359126658930310477L;
    private String oldPassword;
    private String newPassword;

}

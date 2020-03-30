package com.demo.hotel.business.dto.params;


import lombok.Data;

import java.io.Serializable;

/**
 * @program: HotelERPManagementSystem
 * @description: 个人信息参数
 * @author: syj
 * @create: 2020-03-30 14:22
 **/
@Data
public class ProfileParam implements Serializable {

    /**
     * 管理员Id
     */
    private Long id;

    /**
     * 职工Id
     */
    private Long employeeId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 头像
     */
    private String icon;

    /**
     * 性别
     */
    private Integer gender;
}

package com.demo.hotel.business.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: HotelERPManagementSystem
 * @description: Admin的数据传输对象
 * @author: syj
 * @create: 2020-03-30 14:04
 **/
@Data
public class AdminDTO implements Serializable {

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
     * 用户名
     */
    private String nickname;

    /**
     * 邮箱
     */
    private String email;


    /**
     * 手机号
     */
    private String phone;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 头像
     */
    private String icon;

    /**
     * 性别
     */
    private Integer gender;
}

package com.demo.hotel.business.dto;

import lombok.Data;

import java.util.Date;

/**
 * @program: HotelERPManagementSystem
 * @description: Admin的数据传输对象
 * @author: syj
 * @create: 2020-03-30 14:04
 **/
@Data
public class UserDTO implements TableDTO{


    private static final long serialVersionUID = 4192431383432429803L;
    /**
     * ID
     */
    private Long id;

    /**
     * 姓名
     */
    private String username;

    /**
     * 身份证号
     */
    private String identify;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 密码
     */
    private String password;

    /**
     * 创建时间
     */

    private Date creatTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 头像
     */
    private String icon;

    /**
     * 性别，0保密，1男2女
     */
    private Integer gender;

    /**
     * 紧急联系人姓名
     */
    private String name2;

    /**
     * 紧急联系人电话
     */
    private String phone2;
}

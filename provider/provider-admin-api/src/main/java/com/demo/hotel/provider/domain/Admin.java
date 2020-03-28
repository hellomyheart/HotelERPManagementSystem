package com.demo.hotel.provider.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

/**
 * @author syj
 */
@Data
@Table(name = "`admin`")
public class Admin implements Serializable {
    /**
     * 管理员Id
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 职工Id
     */
    @Column(name = "employee_id")
    private Long employeeId;

    /**
     * 用户名
     */
    @Column(name = "username")
    private String username;

    /**
     * 邮箱
     */
    @Column(name = "email")
    private String email;

    /**
     * 密码
     */
    @Column(name = "`password`")
    private String password;

    /**
     * 手机号
     */
    @Column(name = "phone")
    private String phone;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 头像
     */
    @Column(name = "icon")
    private String icon;

    @Column(name = "gender")
    private Integer gender;

    private static final long serialVersionUID = 1L;
}
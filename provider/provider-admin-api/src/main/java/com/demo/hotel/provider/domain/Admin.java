package com.demo.hotel.provider.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

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
     * 昵称
     */
    @Column(name = "nickname")
    private String nickname;

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 头像
     */
    @Column(name = "icon")
    private String icon;

    /**
     * 性别
     */
    @Column(name = "gender")
    private Integer gender;

    private static final long serialVersionUID = 4864000232760089608L;
}
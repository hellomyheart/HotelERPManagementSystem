package com.demo.hotel.provider.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import com.demo.hotel.provider.doamin.TableDomain;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * @author syj
 */
@Data
@Table(name = "users")
public class Users implements TableDomain {

    private static final long serialVersionUID = -1057138337278166453L;
    /**
     * ID
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 姓名
     */
    @Column(name = "username")
    private String username;

    /**
     * 身份证号
     */
    @Column(name = "identify")
    private String identify;

    /**
     * 昵称
     */
    @Column(name = "nickname")
    private String nickname;

    /**
     * 手机号
     */
    @Column(name = "phone")
    private String phone;

    /**
     * 密码
     */
    @Column(name = "`password`")
    private String password;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "creat_time")
    private Date creatTime;

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
     * 性别，0保密，1男2女
     */
    @Column(name = "gender")
    private Integer gender;

    /**
     * 紧急联系人姓名
     */
    @Column(name = "name_2")
    private String name2;

    /**
     * 紧急联系人电话
     */
    @Column(name = "phone_2")
    private String phone2;

}
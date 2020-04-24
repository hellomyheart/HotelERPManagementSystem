package com.demo.hotel.provider.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import com.demo.hotel.provider.doamin.TableDomain;
import lombok.Data;

@Data
@Table(name = "employee")
public class Employee implements TableDomain {

    private static final long serialVersionUID = -9049478278019381120L;
    /**
     * 职工ID
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 职位Id
     */
    @Column(name = "position_id")
    private Long positionId;

    /**
     * 职工姓名
     */
    @Column(name = "employee_name")
    private String employeeName;

    /**
     * 身份证号
     */
    @Column(name = "identify")
    private String identify;

    /**
     * 手机号
     */
    @Column(name = "phone")
    private String phone;

    /**
     * 入职时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 性别
     */
    @Column(name = "gender")
    private Integer gender;

    /**
     * 出生日期
     */
    @Column(name = "birthday")
    private Date birthday;

}
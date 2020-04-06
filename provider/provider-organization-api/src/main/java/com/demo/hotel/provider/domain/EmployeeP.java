package com.demo.hotel.provider.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "employee_p")
public class EmployeeP implements Serializable {

    private static final long serialVersionUID = -4072317838075047864L;
    /**
     * 职工ID
     */
    @Column(name = "id")
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

    /**
     * 职位名
     */
    @Column(name = "position_name")
    private String positionName;

}
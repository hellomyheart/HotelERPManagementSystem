package com.demo.hotel.business.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * @program: HotelERPManagementSystem
 * @description: EmployeePDTO
 * @author: syj
 * @create: 2020-04-06 19:08
 **/
@Data
public class EmployeePDTO implements ViewDTO {

    private static final long serialVersionUID = 7657878244453915929L;
    /**
     * 职工ID
     */
    private Long id;

    /**
     * 职位Id
     */
    private Long positionId;

    /**
     * 职工姓名
     */
    private String employeeName;

    /**
     * 身份证号
     */
    private String identify;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 入职时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 出生日期
     */
    private LocalDate birthday;

    /**
     * 状态，0正常，1休假，2离职
     */
    private Integer status;

    /**
     * 职位名
     */
    private String positionName;

}

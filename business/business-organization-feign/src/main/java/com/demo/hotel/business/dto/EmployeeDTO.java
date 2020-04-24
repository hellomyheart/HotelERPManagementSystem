package com.demo.hotel.business.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: HotelERPManagementSystem
 * @description: EmployeeDTO
 * @author: syj
 * @create: 2020-04-06 19:11
 **/
@Data
public class EmployeeDTO implements TableDTO {


    private static final long serialVersionUID = 1465006554965827889L;
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
    private Date birthday;

}

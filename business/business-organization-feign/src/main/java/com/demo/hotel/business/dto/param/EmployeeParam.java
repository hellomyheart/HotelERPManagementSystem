package com.demo.hotel.business.dto.param;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * @program: HotelERPManagementSystem
 * @description: EmployeeParam
 * @author: syj
 * @create: 2020-04-06 19:14
 **/
@Data
public class EmployeeParam implements BaseParam {

    private static final long serialVersionUID = 366607196488325920L;


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

}

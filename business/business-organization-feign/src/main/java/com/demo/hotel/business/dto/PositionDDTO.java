package com.demo.hotel.business.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: HotelERPManagementSystem
 * @description: PositionDDTO
 * @author: syj
 * @create: 2020-04-06 17:13
 **/
@Data
public class PositionDDTO implements Serializable {


    private static final long serialVersionUID = -5689808030425209856L;
    /**
     * 职位ID
     */
    private Long id;

    /**
     * 部门ID
     */
    private Integer departmentId;

    /**
     * 职位名
     */
    private String positionName;

    /**
     * 基础工资
     */
    private Double basesalary;

    /**
     * 基础工时
     */
    private Double baseTime;

    /**
     * 部门名
     */
    private String departmentName;
}

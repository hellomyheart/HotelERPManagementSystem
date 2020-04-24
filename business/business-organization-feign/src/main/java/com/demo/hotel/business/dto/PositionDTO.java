package com.demo.hotel.business.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: HotelERPManagementSystem
 * @description: PositionDTO
 * @author: syj
 * @create: 2020-04-06 17:15
 **/
@Data
public class PositionDTO implements TableDTO {

    private static final long serialVersionUID = 5573776996827968237L;

    /**
     * 职位ID
     */
    private Long id;

    /**
     * 部门ID
     */
    private Long departmentId;

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

}

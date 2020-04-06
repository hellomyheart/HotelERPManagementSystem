package com.demo.hotel.business.dto.param;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: HotelERPManagementSystem
 * @description: PositionParam
 * @author: syj
 * @create: 2020-04-06 17:17
 **/
@Data
public class PositionParam implements Serializable {

    private static final long serialVersionUID = -1473395228322908698L;

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

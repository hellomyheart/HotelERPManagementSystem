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
public class PerformanceEDTO implements ViewDTO {

    private static final long serialVersionUID = 7657878244453915929L;
    /**
     * ID
     */
    private Long id;

    /**
     * 时间
     */
    private Date creatTime;

    /**
     * 职工Id
     */
    private Long employeeId;

    /**
     * 绩效打分
     */
    private Integer score;

    /**
     * 职工姓名
     */
    private String employeeName;

}

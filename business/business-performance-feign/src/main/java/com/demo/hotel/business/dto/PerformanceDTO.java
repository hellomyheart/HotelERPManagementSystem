package com.demo.hotel.business.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * @program: HotelERPManagementSystem
 * @description: EmployeeDTO
 * @author: syj
 * @create: 2020-04-06 19:11
 **/
@Data
public class PerformanceDTO implements TableDTO {


    private static final long serialVersionUID = 3699853762376536466L;
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

}

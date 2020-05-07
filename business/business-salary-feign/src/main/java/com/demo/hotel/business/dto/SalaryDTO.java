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
public class SalaryDTO implements TableDTO {


    private static final long serialVersionUID = -9066837923242438495L;
    /**
     * ID
     */
    private Long id;

    /**
     * 时间
     */
    private Date creatDate;

    /**
     * 职工ID
     */
    private Long employeeId;

    /**
     * 实际工资
     */
    private Double reale;

}

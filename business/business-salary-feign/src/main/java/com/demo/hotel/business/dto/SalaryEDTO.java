package com.demo.hotel.business.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * @program: HotelERPManagementSystem
 * @description: vDTO
 * @author: syj
 * @create: 2020-04-06 19:08
 **/
@Data
public class SalaryEDTO implements ViewDTO {

    private static final long serialVersionUID = 8973855996255934644L;
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

    /**
     * 职工姓名
     */
    private String employeeName;

}

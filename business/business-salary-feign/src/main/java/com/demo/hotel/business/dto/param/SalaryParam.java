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
public class SalaryParam implements BaseParam {

    private static final long serialVersionUID = 2286130074016967443L;


    /**
     * 职工ID
     */
    private Long employeeId;

    /**
     * 实际工资
     */
    private Double reale;

}

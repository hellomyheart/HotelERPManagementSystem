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
public class PerformanceParam implements BaseParam {

    private static final long serialVersionUID = -7161896410126396601L;


    /**
     * 职工Id
     */
    private Long employeeId;

    /**
     * 绩效打分
     */
    private Integer score;

}

package com.demo.hotel.business.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * @program: HotelERPManagementSystem
 * @description: 排班职工DTO
 * @author: syj
 * @create: 2020-04-07 17:36
 **/
@Data
public class ShiftEmployeeDTO implements TableDTO {

    private static final long serialVersionUID = -8994434520196057876L;


    /**
     * id
     */
    private Long id;

    /**
     * 排班班次ID
     */
    private Long shiftId;

    /**
     * 工作日期
     */
    private LocalDate workDate;

    /**
     * 职工号
     */
    private Long employeeId;

    /**
     * 考勤状态0.正常1.缺勤，2.迟到
     */
    private Integer attendanceStatus;


}

package com.demo.hotel.business.dto.param;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * @program: HotelERPManagementSystem
 * @description: 排班职工
 * @author: syj
 * @create: 2020-04-07 17:43
 **/
@Data
public class ShiftEmployeeParam implements Serializable {

    private static final long serialVersionUID = -6372355350306419552L;

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
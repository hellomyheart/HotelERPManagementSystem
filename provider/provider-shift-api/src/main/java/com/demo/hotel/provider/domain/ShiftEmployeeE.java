package com.demo.hotel.provider.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;

import com.demo.hotel.provider.doamin.ViewDomain;
import lombok.Data;

@Data
@Table(name = "shift_employee_e")
public class ShiftEmployeeE implements ViewDomain {


    private static final long serialVersionUID = -3622578614116870506L;
    /**
     * id
     */
    @Column(name = "id")
    private Long id;

    /**
     * 排班班次ID
     */
    @Column(name = "shift_id")
    private Long shiftId;

    /**
     * 工作日期
     */
    @Column(name = "work_date")
    private LocalDate workDate;

    /**
     * 职工号
     */
    @Column(name = "employee_id")
    private Long employeeId;

    /**
     * 考勤状态0.正常1.缺勤，2.迟到
     */
    @Column(name = "attendance_status")
    private Integer attendanceStatus;

    /**
     * 职工姓名
     */
    @Column(name = "employee_name")
    private String employeeName;

    /**
     * 班次标题
     */
    @Column(name = "title")
    private String title;

}
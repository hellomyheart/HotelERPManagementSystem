package com.demo.hotel.provider.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "shift_employee")
public class ShiftEmployee implements Serializable {

    private static final long serialVersionUID = -1235312546686429753L;
    /**
     * id
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
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


}
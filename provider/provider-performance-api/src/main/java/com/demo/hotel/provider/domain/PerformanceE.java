package com.demo.hotel.provider.domain;

import java.util.Date;
import javax.persistence.*;

import com.demo.hotel.provider.doamin.ViewDomain;
import lombok.Data;

/**
 * @author syj
 */
@Data
@Table(name = "performance_e")
public class PerformanceE implements ViewDomain {
    private static final long serialVersionUID = 8730739175810441570L;
    /**
     * ID
     */
    @Column(name = "id")
    private Long id;

    /**
     * 时间
     */
    @Column(name = "creat_time")
    private Date creatTime;

    /**
     * 职工Id
     */
    @Column(name = "employee_id")
    private Long employeeId;

    /**
     * 绩效打分
     */
    @Column(name = "score")
    private Integer score;

    /**
     * 职工姓名
     */
    @Column(name = "employee_name")
    private String employeeName;
}
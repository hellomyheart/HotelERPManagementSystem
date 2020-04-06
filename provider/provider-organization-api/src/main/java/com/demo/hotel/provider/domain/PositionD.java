package com.demo.hotel.provider.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "position_d")
public class PositionD implements Serializable {

    private static final long serialVersionUID = -2207527025531568010L;
    /**
     * 职位ID
     */
    @Column(name = "id")
    private Long id;

    /**
     * 部门ID
     */
    @Column(name = "department_id")
    private Integer departmentId;

    /**
     * 职位名
     */
    @Column(name = "position_name")
    private String positionName;

    /**
     * 基础工资
     */
    @Column(name = "baseSalary")
    private Double basesalary;

    /**
     * 基础工时
     */
    @Column(name = "base_time")
    private Double baseTime;

    /**
     * 部门名
     */
    @Column(name = "department_name")
    private String departmentName;
}
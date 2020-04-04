package com.demo.hotel.provider.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "`position`")
public class Position implements Serializable {
    /**
     * 职位ID
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 职位名
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 基础工资
     */
    @Column(name = "baseSalary")
    private Double basesalary;

    /**
     * 基础工时
     */
    @Column(name = "`time`")
    private Double time;

    /**
     * 部门ID
     */
    @Column(name = "deployment_id")
    private Long deploymentId;

    private static final long serialVersionUID = 5445426651711132586L;
}
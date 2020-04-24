package com.demo.hotel.provider.domain;

import java.io.Serializable;
import javax.persistence.*;

import com.demo.hotel.provider.doamin.TableDomain;
import lombok.Data;

@Data
@Table(name = "`position`")
public class Position implements TableDomain {

    private static final long serialVersionUID = -920475015226776766L;
    /**
     * 职位ID
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 部门ID
     */
    @Column(name = "department_id")
    private Long departmentId;

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


}
package com.demo.hotel.provider.domain;

import java.util.Date;
import javax.persistence.*;

import com.demo.hotel.provider.doamin.ViewDomain;
import lombok.Data;

@Data
@Table(name = "salary_e")
public class SalaryE implements ViewDomain {

    private static final long serialVersionUID = 8630416918501242967L;
    /**
     * ID
     */
    @Column(name = "id")
    private Long id;

    /**
     * 时间
     */
    @Column(name = "creat_date")
    private Date creatDate;

    /**
     * 职工ID
     */
    @Column(name = "employee_id")
    private Long employeeId;

    /**
     * 实际工资
     */
    @Column(name = "reale")
    private Double reale;

    /**
     * 职工姓名
     */
    @Column(name = "employee_name")
    private String employeeName;
}
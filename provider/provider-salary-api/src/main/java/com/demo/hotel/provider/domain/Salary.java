package com.demo.hotel.provider.domain;

import java.util.Date;
import javax.persistence.*;

import com.demo.hotel.provider.doamin.TableDomain;
import lombok.Data;

/**
 * @author syj
 */
@Data
@Table(name = "salary")
public class Salary implements TableDomain {

    private static final long serialVersionUID = -2770824026571521796L;
    /**
     * ID
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
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
}
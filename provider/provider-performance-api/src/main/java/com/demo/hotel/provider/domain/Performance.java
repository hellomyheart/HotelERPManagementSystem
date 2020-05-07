package com.demo.hotel.provider.domain;

import java.util.Date;
import javax.persistence.*;

import com.demo.hotel.provider.doamin.TableDomain;
import lombok.Data;

/**
 * @author syj
 */
@Data
@Table(name = "performance")
public class Performance implements TableDomain {

    private static final long serialVersionUID = 5309688562540035491L;
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
}
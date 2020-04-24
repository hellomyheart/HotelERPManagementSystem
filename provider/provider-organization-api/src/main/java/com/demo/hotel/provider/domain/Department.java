package com.demo.hotel.provider.domain;

import java.io.Serializable;
import javax.persistence.*;

import com.demo.hotel.provider.doamin.TableDomain;
import lombok.Data;

/**
 * @author syj
 */
@Data
@Table(name = "department")
public class Department implements TableDomain {
    private static final long serialVersionUID = 1627315360341866183L;
    /**
     * 部门ID
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 部门名
     */
    @Column(name = "department_name")
    private String departmentName;

    /**
     * 部门介绍
     */
    @Column(name = "note")
    private String note;


}
package com.demo.hotel.provider.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "department")
public class Department implements Serializable {
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
    @Column(name = "`name`")
    private String name;

    /**
     * 部门介绍
     */
    @Column(name = "note")
    private String note;

    private static final long serialVersionUID = 6164778563160687143L;
}
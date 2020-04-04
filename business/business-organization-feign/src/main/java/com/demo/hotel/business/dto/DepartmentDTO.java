package com.demo.hotel.business.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author syj
 */
@Data
public class DepartmentDTO implements Serializable {
    /**
     * 部门ID
     */
    private Long id;

    /**
     * 部门名
     */
    private String name;

    /**
     * 部门介绍
     */
    private String note;
}
package com.demo.hotel.business.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author syj
 */
@Data
public class DepartmentDTO implements TableDTO {

    private static final long serialVersionUID = -4105952180716404741L;
    /**
     * 部门ID
     */
    private Long id;

    /**
     * 部门名
     */
    private String departmentName;

    /**
     * 部门介绍
     */
    private String note;
}
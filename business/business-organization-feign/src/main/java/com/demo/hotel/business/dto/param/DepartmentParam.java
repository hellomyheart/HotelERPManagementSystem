package com.demo.hotel.business.dto.param;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: HotelERPManagementSystem
 * @description: DeploymentParam
 * @author: syj
 * @create: 2020-04-03 15:10
 **/
@Data
public class DepartmentParam implements Serializable {


    private static final long serialVersionUID = 8756661194050798313L;
    /**
     * 部门名
     */
    private String departmentName;

    /**
     * 部门介绍
     */
    private String note;
}

package com.demo.hotel.business.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: HotelERPManagementSystem
 * @description: 排班分类查询DTO
 * @author: syj
 * @create: 2020-04-07 17:05
 **/
@Data
public class ShiftTypeDDTO implements ViewDTO {


    private static final long serialVersionUID = -6037670429011776409L;
    /**
     * 分类ID
     */
    private Long id;

    /**
     * 分类名
     */
    private String typeName;

    /**
     * 部门ID
     */
    private Long departmentId;

    /**
     * 部门名
     */
    private String departmentName;
}

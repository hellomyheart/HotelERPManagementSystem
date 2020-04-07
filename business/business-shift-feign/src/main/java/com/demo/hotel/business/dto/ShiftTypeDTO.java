package com.demo.hotel.business.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: HotelERPManagementSystem
 * @description: 排班分类DTO
 * @author: syj
 * @create: 2020-04-07 17:08
 **/
@Data
public class ShiftTypeDTO implements Serializable {


    private static final long serialVersionUID = 6780781899514356621L;
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

}

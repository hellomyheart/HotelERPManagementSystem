package com.demo.hotel.business.dto.param;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: HotelERPManagementSystem
 * @description: 排班分类Param
 * @author: syj
 * @create: 2020-04-07 17:24
 **/
@Data
public class ShiftTypeParam implements BaseParam {

    private static final long serialVersionUID = 6881379876087115105L;


    /**
     * 分类名
     */
    private String typeName;

    /**
     * 部门ID
     */
    private Long departmentId;

}

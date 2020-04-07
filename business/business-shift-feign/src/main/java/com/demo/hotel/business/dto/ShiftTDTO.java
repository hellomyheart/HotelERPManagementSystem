package com.demo.hotel.business.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: HotelERPManagementSystem
 * @description: 排班班次查询dto
 * @author: syj
 * @create: 2020-04-07 17:26
 **/
@Data
public class ShiftTDTO  implements Serializable {

    private static final long serialVersionUID = 1998082678936239919L;

    /**
     * id
     */
    private Long id;

    /**
     * 分类ID
     */
    private Long typeId;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 工时
     */
    private Integer times;

    /**
     * 分类名
     */
    private String typeName;

}

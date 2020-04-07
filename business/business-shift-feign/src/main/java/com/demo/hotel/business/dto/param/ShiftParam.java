package com.demo.hotel.business.dto.param;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: HotelERPManagementSystem
 * @description: 排班班次Param
 * @author: syj
 * @create: 2020-04-07 17:30
 **/
@Data
public class ShiftParam implements Serializable {


    private static final long serialVersionUID = 4875726612518023663L;


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
}

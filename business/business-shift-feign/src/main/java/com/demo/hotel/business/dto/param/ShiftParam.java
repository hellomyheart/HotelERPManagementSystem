package com.demo.hotel.business.dto.param;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalTime;
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
     * 班次标题
     */
    private String title;

    /**
     * 开始时间
     */
    private LocalTime startTime;

    /**
     * 结束时间
     */
    private LocalTime endTime;

    /**
     * 工时
     */
    private Integer times;
}

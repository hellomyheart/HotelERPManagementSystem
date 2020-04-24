package com.demo.hotel.business.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;

/**
 * @program: HotelERPManagementSystem
 * @description: 排班班次DTO
 * @author: syj
 * @create: 2020-04-07 17:27
 **/
@Data
public class ShiftDTO implements TableDTO {

    private static final long serialVersionUID = -8243325415424030774L;

    /**
     * id
     */
    private Long id;

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

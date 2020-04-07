package com.demo.hotel.business.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: HotelERPManagementSystem
 * @description: 排班班次DTO
 * @author: syj
 * @create: 2020-04-07 17:27
 **/
@Data
public class ShiftDTO implements Serializable {

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

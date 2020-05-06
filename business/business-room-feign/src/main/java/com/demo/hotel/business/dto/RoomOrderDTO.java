package com.demo.hotel.business.dto;

import lombok.Data;

import java.util.Date;

/**
 * @program: HotelERPManagementSystem
 * @description: RoomOrderDTO
 * @author: syj
 * @create: 2020-05-06 08:16
 **/
@Data
public class RoomOrderDTO implements TableDTO {

    private static final long serialVersionUID = -3614564092203916401L;

    private Long id;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 客房ID
     */
    private Long roomId;

    /**
     * 押金状态，0未付，1已付，2已退
     */
    private Integer depositStatus;

    /**
     * 押金
     */
    private Double depositPrice;

    /**
     * 订单状态，0未付，1已付
     */
    private Integer orderStatus;

    /**
     * 创建时间
     */
    private Date creatTime;

    /**
     * 价格
     */
    private Double price;

    /**
     * 入住时间
     */
    private Date checkIn;

    /**
     * 天数
     */
    private Integer days;

}

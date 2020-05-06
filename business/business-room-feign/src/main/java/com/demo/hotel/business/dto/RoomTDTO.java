package com.demo.hotel.business.dto;

import lombok.Data;

/**
 * @program: HotelERPManagementSystem
 * @description:
 * @author: syj
 * @create: 2020-05-06 08:18
 **/
@Data
public class RoomTDTO implements ViewDTO {

    private static final long serialVersionUID = -8449726161581882327L;

    /**
     * 客房id
     */
    private Long id;

    /**
     * 客房状态 0,未开放，1客满，2可以入住
     */
    private Integer status;

    /**
     * 位置
     */
    private String location;

    /**
     * 客房类型ID
     */
    private Long typeId;

    /**
     * 类型名
     */
    private String typeName;

    /**
     * 图片
     */
    private String picture;

    /**
     * 描述
     */
    private String note;

    /**
     * 价格
     */
    private Double price;

    /**
     * 押金
     */
    private Double deposit;

    /**
     * 床位数
     */
    private Integer bedCount;

    private Long roomid;
}

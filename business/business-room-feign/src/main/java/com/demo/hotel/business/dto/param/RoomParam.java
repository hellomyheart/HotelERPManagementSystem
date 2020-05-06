package com.demo.hotel.business.dto.param;

import lombok.Data;

/**
 * @program: HotelERPManagementSystem
 * @description:
 * @author: syj
 * @create: 2020-05-06 08:21
 **/
@Data
public class RoomParam implements BaseParam {

    private static final long serialVersionUID = -2176338879406257018L;


    /**
     * 位置
     */
    private String location;

    /**
     * 客房类型ID
     */
    private Long typeId;
}

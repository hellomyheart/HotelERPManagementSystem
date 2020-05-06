package com.demo.hotel.business.dto;

import lombok.Data;

/**
 * @program: HotelERPManagementSystem
 * @description: 房间DTO
 * @author: syj
 * @create: 2020-05-06 08:14
 **/
@Data
public class RoomDTO implements TableDTO {

    private static final long serialVersionUID = 4150725300864261675L;

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

}

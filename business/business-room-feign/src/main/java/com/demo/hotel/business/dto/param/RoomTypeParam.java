package com.demo.hotel.business.dto.param;

import lombok.Data;

/**
 * @program: HotelERPManagementSystem
 * @description:
 * @author: syj
 * @create: 2020-05-06 09:21
 **/
@Data
public class RoomTypeParam implements BaseParam {

    private static final long serialVersionUID = -4202639597914956977L;
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

}

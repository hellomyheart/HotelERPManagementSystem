package com.demo.hotel.business.dto.param;

import lombok.Data;

/**
 * @program: HotelERPManagementSystem
 * @description:
 * @author: syj
 * @create: 2020-04-29 14:49
 **/
@Data
public class FoodParam implements BaseParam {


    private static final long serialVersionUID = 3102676245097462579L;

    /**
     * 分类
     */
    private Long typeId;

    /**
     * 食材名
     */
    private String foodName;

    /**
     * 数量
     */
    private Integer foodNumber;

    /**
     * 备注
     */
    private String note;
}

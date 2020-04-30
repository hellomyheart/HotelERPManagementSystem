package com.demo.hotel.business.dto;

import lombok.Data;

/**
 * @program: HotelERPManagementSystem
 * @description:
 * @author: syj
 * @create: 2020-04-30 08:16
 **/
@Data
public class FoodDTO implements TableDTO{

    private static final long serialVersionUID = -8848105997707793905L;
    /**
     * id
     */
    private Long id;

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



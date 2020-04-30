package com.demo.hotel.business.dto;

import lombok.Data;

/**
 * @program: HotelERPManagementSystem
 * @description: 视图
 * @author: syj
 * @create: 2020-04-29 15:01
 **/
@Data
public class FoodTDTO implements ViewDTO {


    private static final long serialVersionUID = -5392361095540824322L;

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

    /**
     * 分类名
     */
    private String typeName;

}

package com.demo.hotel.business.dto.param;

import lombok.Data;


/**
 * @program: HotelERPManagementSystem
 * @description: 采购Param
 * @author: syj
 * @create: 2020-04-29 14:57
 **/
@Data
public class FoodProcurementParam implements BaseParam{

    private static final long serialVersionUID = -8468023493308703322L;


    /**
     * 采购商ID
     */
    private Long buyerId;

    /**
     * 食材ID
     */
    private Long foodId;

    /**
     * 采购单价
     */
    private Double foodPrice;

    /**
     * 采购数量
     */
    private Double foodCount;


    /**
     * 备注
     */
    private String note;
}

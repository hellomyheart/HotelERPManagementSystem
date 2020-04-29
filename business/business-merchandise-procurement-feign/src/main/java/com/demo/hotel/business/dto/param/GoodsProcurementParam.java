package com.demo.hotel.business.dto.param;

import lombok.Data;

import java.util.Date;

/**
 * @program: HotelERPManagementSystem
 * @description: 采购Param
 * @author: syj
 * @create: 2020-04-29 14:57
 **/
@Data
public class GoodsProcurementParam implements BaseParam{

    private static final long serialVersionUID = -6522928033687442294L;


    /**
     * 采购商ID
     */
    private Long buyerId;

    /**
     * 商品ID
     */
    private Long goodsId;

    /**
     * 单价
     */
    private Double price;

    /**
     * 采购数目
     */
    private Double procurementSum;


    //createTime自动生成

    /**
     * 备注
     */
    private String note;
}

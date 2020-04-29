package com.demo.hotel.business.dto;

import lombok.Data;

import java.util.Date;

/**
 * @program: HotelERPManagementSystem
 * @description: 采购视图DTO
 * @author: syj
 * @create: 2020-04-29 14:59
 **/
@Data
public class GoodsProcurementBgDTO implements ViewDTO{

    private static final long serialVersionUID = 3269699113474755738L;
    /**
     * ID
     */
    private Long id;

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

    /**
     * 时间
     */
    private Date createTime;

    /**
     * 备注
     */
    private String note;

    /**
     * 采购商名
     */
    private String buyerName;

    /**
     * 商品名
     */
    private String goodsName;

}

package com.demo.hotel.business.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author syj
 */
@Data
public class GoodsDTO implements TableDTO {


    private static final long serialVersionUID = 5794199831437421303L;
    /**
     * 商品ID
     */
    private Long id;

    /**
     * 商品条码
     */
    private String goodsCode;

    /**
     * 商品名
     */
    private String goodsName;

    /**
     * 库存数量
     */
    private Double goodsSum;

    /**
     * 说明
     */
    private String note;
}
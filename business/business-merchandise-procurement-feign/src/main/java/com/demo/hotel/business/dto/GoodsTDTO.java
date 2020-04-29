package com.demo.hotel.business.dto;

import lombok.Data;

/**
 * @program: HotelERPManagementSystem
 * @description: 商品视图
 * @author: syj
 * @create: 2020-04-29 15:01
 **/
@Data
public class GoodsTDTO implements ViewDTO {


    private static final long serialVersionUID = -4817365362226009081L;

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
     * 图片
     */
    private String picture;

    /**
     * 商品类型
     */
    private Long typeId;

    /**
     * 价格
     */
    private Double price;

    /**
     * 库存数量
     */
    private Double goodsSum;

    /**
     * 说明
     */
    private String note;

    /**
     * 分类名
     */
    private String typeName;

}

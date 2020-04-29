package com.demo.hotel.business.dto.param;

import lombok.Data;

/**
 * @program: HotelERPManagementSystem
 * @description:
 * @author: syj
 * @create: 2020-04-29 14:49
 **/
@Data
public class GoodsParam implements BaseParam {


    private static final long serialVersionUID = 7577326665721996263L;

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
}

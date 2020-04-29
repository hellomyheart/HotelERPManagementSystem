package com.demo.hotel.business.dto;

import lombok.Data;

import java.util.Date;

/**
 * @program: HotelERPManagementSystem
 * @description: 采购DTO
 * @author: syj
 * @create: 2020-04-29 14:57
 **/
@Data
public class GoodsProcurementDTO  implements TableDTO{

    private static final long serialVersionUID = 5803615707903373144L;
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
}

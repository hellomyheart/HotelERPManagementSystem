package com.demo.hotel.business.dto;

import lombok.Data;

import java.time.LocalDate;

/**
 * @program: HotelERPManagementSystem
 * @description: 采购视图DTO
 * @author: syj
 * @create: 2020-04-29 14:59
 **/
@Data
public class FoodProcurementBfDTO implements ViewDTO{

    private static final long serialVersionUID = -5278165440863461048L;
    /**
     * ID
     */
    private Long id;

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
     * 创建时间
     */
    private LocalDate creatTime;

    /**
     * 备注
     */
    private String note;

    /**
     * 采购商名
     */
    private String buyerName;

    /**
     * 食材名
     */
    private String foodName;

}

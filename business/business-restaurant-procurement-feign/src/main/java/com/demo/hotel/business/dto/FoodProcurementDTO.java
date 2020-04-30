package com.demo.hotel.business.dto;

import lombok.Data;

import java.time.LocalDate;

/**
 * @program: HotelERPManagementSystem
 * @description: 采购DTO
 * @author: syj
 * @create: 2020-04-29 14:57
 **/
@Data
public class FoodProcurementDTO implements TableDTO{

    private static final long serialVersionUID = -7442583698932808228L;
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
}

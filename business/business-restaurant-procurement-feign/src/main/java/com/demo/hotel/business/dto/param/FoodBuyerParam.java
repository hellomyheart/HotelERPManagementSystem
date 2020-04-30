package com.demo.hotel.business.dto.param;

import lombok.Data;

/**
 * @program: HotelERPManagementSystem
 * @description: 采购商DTO
 * @author: syj
 * @create: 2020-04-29 14:54
 **/
@Data
public class FoodBuyerParam implements BaseParam{

    private static final long serialVersionUID = 3768018965155612625L;


    /**
     * 采购商名
     */
    private String buyerName;

    /**
     * 公司名
     */
    private String company;

    /**
     * 公司地址
     */
    private String companyAdd;
}

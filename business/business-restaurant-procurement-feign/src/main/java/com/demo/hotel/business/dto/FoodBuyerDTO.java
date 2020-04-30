package com.demo.hotel.business.dto;

import lombok.Data;

/**
 * @program: HotelERPManagementSystem
 * @description: 采购商DTO
 * @author: syj
 * @create: 2020-04-29 14:54
 **/
@Data
public class FoodBuyerDTO implements TableDTO{

    private static final long serialVersionUID = 5180248124473394709L;
    /**
     * id
     */
    private Long id;

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
package com.demo.hotel.business.dto.param;

import lombok.Data;

/**
 * @program: HotelERPManagementSystem
 * @description: 采购商DTO
 * @author: syj
 * @create: 2020-04-29 14:54
 **/
@Data
public class GoodsBuyerParam implements BaseParam{

    private static final long serialVersionUID = -7726043033866586132L;


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

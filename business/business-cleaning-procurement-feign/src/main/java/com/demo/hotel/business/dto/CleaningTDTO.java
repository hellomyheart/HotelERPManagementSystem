package com.demo.hotel.business.dto;

import lombok.Data;

/**
 * @program: HotelERPManagementSystem
 * @description: 商品视图
 * @author: syj
 * @create: 2020-04-29 15:01
 **/
@Data
public class CleaningTDTO implements ViewDTO {


    private static final long serialVersionUID = -7167253051200354349L;

    /**
     * id
     */
    private Long id;

    /**
     * 分类
     */
    private Long typeId;

    /**
     * 用品名
     */
    private String cleaningName;

    /**
     * 数量
     */
    private Double cleaningNumber;

    /**
     * 备注
     */
    private String note;

    /**
     * 分类名
     */
    private String typeName;

}

package com.demo.hotel.business.dto;

import lombok.Data;

/**
 * @program: HotelERPManagementSystem
 * @description: 商品类别DTO
 * @author: syj
 * @create: 2020-04-29 15:03
 **/
@Data
public class GoodsTypeDTO implements TableDTO{

    private static final long serialVersionUID = -1566567079954467601L;
    /**
     * ID
     */
    private Long id;

    /**
     * 分类名
     */
    private String typeName;

}

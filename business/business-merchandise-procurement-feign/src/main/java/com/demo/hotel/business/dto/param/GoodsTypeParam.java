package com.demo.hotel.business.dto.param;

import lombok.Data;

/**
 * @program: HotelERPManagementSystem
 * @description: 商品类别Param
 * @author: syj
 * @create: 2020-04-29 15:03
 **/
@Data
public class GoodsTypeParam implements BaseParam{


    private static final long serialVersionUID = -2653568972514994100L;
    /**
     * 分类名
     */
    private String typeName;

}

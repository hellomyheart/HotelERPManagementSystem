package com.demo.hotel.business.dto.param;

import lombok.Data;

/**
 * @program: HotelERPManagementSystem
 * @description: 商品类别Param
 * @author: syj
 * @create: 2020-04-29 15:03
 **/
@Data
public class CleaningTypeParam implements BaseParam{


    private static final long serialVersionUID = -1278745477537694973L;
    /**
     * 分类名
     */
    private String typeName;

}

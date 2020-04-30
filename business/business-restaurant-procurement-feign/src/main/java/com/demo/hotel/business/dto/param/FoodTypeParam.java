package com.demo.hotel.business.dto.param;

import lombok.Data;

/**
 * @program: HotelERPManagementSystem
 * @description: 类别Param
 * @author: syj
 * @create: 2020-04-29 15:03
 **/
@Data
public class FoodTypeParam implements BaseParam{


    private static final long serialVersionUID = -1435223514315442915L;
    /**
     * 分类名
     */
    private String typeName;

}

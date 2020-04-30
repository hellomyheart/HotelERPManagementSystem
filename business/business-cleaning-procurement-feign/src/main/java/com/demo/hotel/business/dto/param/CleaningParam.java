package com.demo.hotel.business.dto.param;

import lombok.Data;

/**
 * @program: HotelERPManagementSystem
 * @description:
 * @author: syj
 * @create: 2020-04-29 14:49
 **/
@Data
public class CleaningParam implements BaseParam {


    private static final long serialVersionUID = 4933917977069383398L;

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
}

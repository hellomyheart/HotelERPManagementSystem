package com.demo.hotel.business.dto.param;

import lombok.Data;


/**
 * @program: HotelERPManagementSystem
 * @description: 采购Param
 * @author: syj
 * @create: 2020-04-29 14:57
 **/
@Data
public class CleaningProcurementParam implements BaseParam{

    private static final long serialVersionUID = 664601774148692973L;


    /**
     * 采购商ID
     */
    private Long buyerId;

    /**
     * 保洁用品id
     */
    private Long cleaningId;

    /**
     * 单价
     */
    private Double cleaningPrice;

    /**
     * 数量
     */
    private Double cleaningNubmer;

    /**
     * 时间
     */

    /**
     * 备注
     */
    private String note;
}

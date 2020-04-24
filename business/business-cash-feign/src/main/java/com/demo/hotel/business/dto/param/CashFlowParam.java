package com.demo.hotel.business.dto.param;

import lombok.Data;

/**
 * @program: HotelERPManagementSystem
 * @description: 资金流动Param
 * @author: syj
 * @create: 2020-04-24 18:08
 **/
@Data
public class CashFlowParam implements BaseParam {

    private static final long serialVersionUID = -6831919222232863091L;

    /**
     * 流动类型,0出，1入
     */
    private Integer flowType;

    /**
     * 金额
     */
    private Double money;

    /**
     * 备注
     */
    private String note;


}

package com.demo.hotel.business.dto;

import lombok.Data;

/**
 * @program: HotelERPManagementSystem
 * @description: 资金流动DTO
 * @author: syj
 * @create: 2020-04-24 18:06
 **/
@Data
public class CashFlowDTO implements TableDTO {


    private static final long serialVersionUID = -3054093261513668851L;
    /**
     * ID
     */
    private Long id;

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

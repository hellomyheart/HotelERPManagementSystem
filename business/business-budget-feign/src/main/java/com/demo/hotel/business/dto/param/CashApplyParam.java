package com.demo.hotel.business.dto.param;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: HotelERPManagementSystem
 * @author: syj
 * @create: 2020-04-03 15:10
 **/
@Data
public class CashApplyParam implements BaseParam {


    private static final long serialVersionUID = 229889258642239667L;
    /**
     * 标题
     */
    private String title;


    /**
     * 资金
     */
    private Double price;

    /**
     * 说明
     */
    private String note;

    /**
     * 申请人
     */
    private Long applyId;

    /**
     * 状态，0申请，1通过
     */
    private Integer status;
}

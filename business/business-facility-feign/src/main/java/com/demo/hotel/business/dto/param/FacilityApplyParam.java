package com.demo.hotel.business.dto.param;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: HotelERPManagementSystem
 * @description:
 * @author: syj
 * @create: 2020-04-03 15:10
 **/
@Data
public class FacilityApplyParam implements BaseParam {


    private static final long serialVersionUID = 822008062379929756L;

    /**
     * 标题
     */
    private String title;


    /**
     * 单价
     */
    private Double price;

    /**
     * 单位
     */
    private String unit;

    /**
     * 数量
     */
    private Double quantity;

    /**
     * 总价
     */
    private Double totalPrice;

    /**
     * 详细情况
     */
    private String note;

    /**
     * 申请人
     */
    private Long applyId;

}

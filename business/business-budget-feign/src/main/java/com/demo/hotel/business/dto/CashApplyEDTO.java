package com.demo.hotel.business.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: HotelERPManagementSystem
 * @author: syj
 * @create: 2020-04-06 19:08
 **/
@Data
public class CashApplyEDTO implements ViewDTO {


    private static final long serialVersionUID = -1759391934422546575L;
    /**
     * ID
     */
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 创建时间
     */
    private Date createTime;

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

    /**
     * 职工姓名
     */
    private String employeeName;
}

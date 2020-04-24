package com.demo.hotel.business.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author syj
 */
@Data
public class CashApplyDTO implements TableDTO {


    private static final long serialVersionUID = -2188862172414497244L;
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
}
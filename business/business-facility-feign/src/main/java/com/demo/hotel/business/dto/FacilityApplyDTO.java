package com.demo.hotel.business.dto;

import lombok.Data;

import java.util.Date;

/**
 * @program: HotelERPManagementSystem
 * @description: 设备申请dto
 * @author: syj
 * @create: 2020-04-25 19:06
 **/
@Data
public class FacilityApplyDTO implements TableDTO {


    private static final long serialVersionUID = 822914975630067974L;
    /**
     * ID
     */
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 申请时间
     */
    private Date createTime;

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

    /**
     * 状态,0申请，1通过
     */
    private Integer status;
}

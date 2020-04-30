package com.demo.hotel.business.dto;

import lombok.Data;

import java.time.LocalDate;

/**
 * @program: HotelERPManagementSystem
 * @description: 采购视图DTO
 * @author: syj
 * @create: 2020-04-29 14:59
 **/
@Data
public class CleaningProcurementBcDTO implements ViewDTO{

    private static final long serialVersionUID = 8111904347783926529L;
    /**
     * id
     */
    private Long id;

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
    private LocalDate creatTime;

    /**
     * 备注
     */
    private String note;

    /**
     * 采购商名
     */
    private String buyerName;

    /**
     * 用品名
     */
    private String cleaningName;

}

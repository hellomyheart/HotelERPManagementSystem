package com.demo.hotel.business.dto;

import lombok.Data;

import java.time.LocalDate;

/**
 * @program: HotelERPManagementSystem
 * @description: 采购DTO
 * @author: syj
 * @create: 2020-04-29 14:57
 **/
@Data
public class CleaningProcurementDTO implements TableDTO{

    private static final long serialVersionUID = 6199137289318316990L;
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
}

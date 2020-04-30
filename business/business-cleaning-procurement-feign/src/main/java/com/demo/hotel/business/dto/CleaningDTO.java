package com.demo.hotel.business.dto;

import lombok.Data;

/**
 * @program: HotelERPManagementSystem
 * @description:
 * @author: syj
 * @create: 2020-04-30 08:16
 **/
@Data
public class CleaningDTO implements TableDTO{

    private static final long serialVersionUID = -1101981805938844677L;
    /**
     * id
     */
    private Long id;

    /**
     * 分类
     */
    private Long typeId;

    /**
     * 用品名
     */
    private String cleaningName;

    /**
     * 数量
     */
    private Double cleaningNumber;

    /**
     * 备注
     */
    private String note;
}



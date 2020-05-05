package com.demo.hotel.business.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author syj
 */
@Data
public class RepairsDTO implements TableDTO {

    private static final long serialVersionUID = 6057672625138152732L;
    /**
     * id
     */
    private Long id;

    /**
     * 客房ID
     */
    private Long roomId;

    /**
     * 报修时间
     */
    private Date repairsTime;

    /**
     * 状态，0等待维修，1维修完成
     */
    private Integer status;

    /**
     * 备注
     */
    private String note;
}
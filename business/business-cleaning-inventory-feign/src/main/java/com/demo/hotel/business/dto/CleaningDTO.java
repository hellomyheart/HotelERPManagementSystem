package com.demo.hotel.business.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author syj
 */
@Data
public class CleaningDTO implements TableDTO {


    private static final long serialVersionUID = -1101981805938844677L;
    /**
     * id
     */
    private Long id;

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
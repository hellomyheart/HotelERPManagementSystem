package com.demo.hotel.business.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author syj
 */
@Data
public class FoodDTO implements TableDTO {


    private static final long serialVersionUID = -7987512855199920392L;
    /**
     * id
     */
    private Long id;

    /**
     * 食材名
     */
    private String foodName;

    /**
     * 数量
     */
    private Integer foodNumber;

    /**
     * 备注
     */
    private String note;
}
package com.demo.hotel.business.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author syj
 */
@Data
public class InspectionDTO implements TableDTO {

    private static final long serialVersionUID = 4071346491403888094L;
    /**
     * ID
     */
    private Long id;

    /**
     * 客房ID
     */
    private Long roomId;

    /**
     * 检修时间
     */
    private Date inspectionTime;

    /**
     * 备注
     */
    private String note;
}
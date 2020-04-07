package com.demo.hotel.business.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: HotelERPManagementSystem
 * @description: TrainingDTO
 * @author: syj
 * @create: 2020-04-07 06:48
 **/
@Data
public class TrainingDTO implements Serializable {


    private static final long serialVersionUID = 7317701927266154895L;
    /**
     * id
     */
    private Long id;

    /**
     * 职工ID
     */
    private Long employeeId;

    /**
     * 培训内容ID
     */
    private Long trainingContentId;

    /**
     * 开始时间
     */
    private Date createTime;

    /**
     * 结束时间
     */
    private Date endTime;

}

package com.demo.hotel.business.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: HotelERPManagementSystem
 * @description: TrainingContentPDTO
 * @author: syj
 * @create: 2020-04-07 07:31
 **/
@Data
public class TrainingContentPDTO implements ViewDTO {

    private static final long serialVersionUID = 5075376832666812369L;
    /**
     * id
     */
    private Long id;

    /**
     * 职位ID
     */
    private Long positionId;

    /**
     * 培训内容标题
     */
    private String title;

    /**
     * 简单介绍
     */
    private String note;

    /**
     * 培训时长(天)
     */
    private Integer sumTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 职位名
     */
    private String positionName;

}

package com.demo.hotel.business.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: HotelERPManagementSystem
 * @description: TrainingContentDTO
 * @author: syj
 * @create: 2020-04-07 07:33
 **/
@Data
public class TrainingContentDTO implements Serializable {

    private static final long serialVersionUID = -6074445996057546409L;

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

}

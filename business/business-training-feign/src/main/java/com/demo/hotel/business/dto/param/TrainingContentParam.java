package com.demo.hotel.business.dto.param;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: HotelERPManagementSystem
 * @description:
 * @author: syj
 * @create: 2020-04-07 07:34
 **/
@Data
public class TrainingContentParam implements BaseParam{

    private static final long serialVersionUID = -6011716291372718772L;


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

}

package com.demo.hotel.business.dto.param;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: HotelERPManagementSystem
 * @description: TrainingParam
 * @author: syj
 * @create: 2020-04-07 06:53
 **/
@Data
public class TrainingParam implements BaseParam {

    private static final long serialVersionUID = 4748589646000685381L;



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

}

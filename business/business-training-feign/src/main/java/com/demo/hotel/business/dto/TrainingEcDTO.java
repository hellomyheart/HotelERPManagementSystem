package com.demo.hotel.business.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: HotelERPManagementSystem
 * @description: TrainingEcDTO
 * @author: syj
 * @create: 2020-04-07 06:51
 **/
@Data
public class TrainingEcDTO implements Serializable {

    private static final long serialVersionUID = 1301451087941071343L;


    /**
     * id
     */
    private Integer id;


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


    /**
     * 培训内容标题
     */
    private String title;

    /**
     * 职工姓名
     */
    private String employeeName;
}

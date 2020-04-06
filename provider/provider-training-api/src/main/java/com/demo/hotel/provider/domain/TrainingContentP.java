package com.demo.hotel.provider.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import lombok.Data;

/**
 * @author syj
 */
@Data
@Table(name = "training_content_p")
public class TrainingContentP implements Serializable {

    private static final long serialVersionUID = 2573915995843566143L;
    /**
     * id
     */
    @Column(name = "id")
    private Long id;

    /**
     * 职位ID
     */
    @Column(name = "position_id")
    private Long positionId;

    /**
     * 培训内容标题
     */
    @Column(name = "title")
    private String title;

    /**
     * 简单介绍
     */
    @Column(name = "note")
    private String note;

    /**
     * 培训时长(天)
     */
    @Column(name = "sum_time")
    private Integer sumTime;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 职位名
     */
    @Column(name = "position_name")
    private String positionName;

}
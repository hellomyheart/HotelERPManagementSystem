package com.demo.hotel.provider.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import lombok.Data;

/**
 * @author syj
 */
@Data
@Table(name = "training_ec")
public class TrainingEc implements Serializable {


    private static final long serialVersionUID = 460071636254209960L;
    /**
     * id
     */
    @Column(name = "id")
    private Integer id;

    @Column(name = "employee_id")
    private Long employeeId;

    /**
     * 培训内容ID
     */
    @Column(name = "training_content_id")
    private Long trainingContentId;

    /**
     * 开始时间
     */
    @Column(name = "create_time")
    private LocalDate createTime;

    /**
     * 结束时间
     */
    @Column(name = "end_time")
    private LocalDate endTime;


    /**
     * 培训内容标题
     */
    @Column(name = "title")
    private String title;

    /**
     * 职工姓名
     */
    @Column(name = "employee_name")
    private String employeeName;

}
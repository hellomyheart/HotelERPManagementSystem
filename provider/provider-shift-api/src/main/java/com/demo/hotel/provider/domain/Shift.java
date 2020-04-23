package com.demo.hotel.provider.domain;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "shift")
public class Shift implements Serializable {


    private static final long serialVersionUID = -3885687022405103588L;
    /**
     * id
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 分类ID
     */
    @Column(name = "type_id")
    private Long typeId;

    /**
     * 班次标题
     */
    @Column(name = "title")
    private String title;

    /**
     * 开始时间
     */
    @Column(name = "start_time")
    private LocalTime startTime;

    /**
     * 结束时间
     */
    @Column(name = "end_time")
    private LocalTime endTime;

    /**
     * 工时
     */
    @Column(name = "times")
    private Integer times;

}
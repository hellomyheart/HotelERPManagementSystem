package com.demo.hotel.provider.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "shift_t")
public class ShiftT implements Serializable {
    private static final long serialVersionUID = -3730824392286593667L;
    /**
     * id
     */
    @Column(name = "id")
    private Long id;

    /**
     * 分类ID
     */
    @Column(name = "type_id")
    private Long typeId;

    /**
     * 开始时间
     */
    @Column(name = "start_time")
    private Date startTime;

    /**
     * 结束时间
     */
    @Column(name = "end_time")
    private Date endTime;

    /**
     * 工时
     */
    @Column(name = "times")
    private Integer times;

    /**
     * 分类名
     */
    @Column(name = "type_name")
    private String typeName;


}
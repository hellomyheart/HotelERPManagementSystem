package com.demo.hotel.provider.domain;

import java.util.Date;
import javax.persistence.*;

import com.demo.hotel.provider.doamin.TableDomain;
import lombok.Data;

/**
 * @author syj
 */
@Data
@Table(name = "repairs")
public class Repairs implements TableDomain {
    private static final long serialVersionUID = 4098815616115081426L;
    /**
     * id
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 客房ID
     */
    @Column(name = "room_id")
    private Long roomId;

    /**
     * 报修时间
     */
    @Column(name = "repairs_time")
    private Date repairsTime;

    /**
     * 状态，0等待维修，1维修完成
     */
    @Column(name = "`status`")
    private Integer status;

    /**
     * 备注
     */
    @Column(name = "note")
    private String note;
}
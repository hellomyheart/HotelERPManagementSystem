package com.demo.hotel.provider.domain;

import java.time.LocalDate;
import javax.persistence.*;

import com.demo.hotel.provider.doamin.TableDomain;
import lombok.Data;

/**
 * @author syj
 */
@Data
@Table(name = "cleaning_procurement")
public class CleaningProcurement implements TableDomain {

    private static final long serialVersionUID = 7225975149545557850L;
    /**
     * id
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 采购商ID
     */
    @Column(name = "buyer_id")
    private Long buyerId;

    /**
     * 保洁用品id
     */
    @Column(name = "cleaning_id")
    private Long cleaningId;

    /**
     * 单价
     */
    @Column(name = "cleaning_price")
    private Double cleaningPrice;

    /**
     * 数量
     */
    @Column(name = "cleaning_nubmer")
    private Double cleaningNubmer;

    /**
     * 时间
     */
    @Column(name = "creat_time")
    private LocalDate creatTime;

    /**
     * 备注
     */
    @Column(name = "note")
    private String note;
}
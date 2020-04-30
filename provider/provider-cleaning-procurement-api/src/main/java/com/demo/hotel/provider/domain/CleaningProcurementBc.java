package com.demo.hotel.provider.domain;

import java.time.LocalDate;
import javax.persistence.*;

import com.demo.hotel.provider.doamin.ViewDomain;
import lombok.Data;

/**
 * @author syj
 */
@Data
@Table(name = "cleaning_procurement_bc")
public class CleaningProcurementBc implements ViewDomain {

    private static final long serialVersionUID = -5415776042398994051L;
    /**
     * id
     */
    @Column(name = "id")
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

    /**
     * 采购商名
     */
    @Column(name = "buyer_name")
    private String buyerName;

    /**
     * 用品名
     */
    @Column(name = "cleaning_name")
    private String cleaningName;
}
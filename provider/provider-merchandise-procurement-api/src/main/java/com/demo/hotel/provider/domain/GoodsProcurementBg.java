package com.demo.hotel.provider.domain;

import java.time.LocalDate;
import javax.persistence.*;

import com.demo.hotel.provider.doamin.ViewDomain;
import lombok.Data;

/**
 * @author syj
 */
@Data
@Table(name = "goods_procurement_bg")
public class GoodsProcurementBg implements ViewDomain {

    private static final long serialVersionUID = -3210707341388161032L;
    /**
     * ID
     */
    @Column(name = "id")
    private Long id;

    /**
     * 采购商ID
     */
    @Column(name = "buyer_id")
    private Long buyerId;

    /**
     * 商品ID
     */
    @Column(name = "goods_id")
    private Long goodsId;

    /**
     * 单价
     */
    @Column(name = "price")
    private Double price;

    /**
     * 采购数目
     */
    @Column(name = "procurement_sum")
    private Double procurementSum;

    /**
     * 时间
     */
    @Column(name = "create_time")
    private LocalDate createTime;

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
     * 商品名
     */
    @Column(name = "goods_name")
    private String goodsName;
}
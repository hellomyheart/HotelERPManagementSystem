package com.demo.hotel.provider.domain;

import java.time.LocalDate;
import javax.persistence.*;

import com.demo.hotel.provider.doamin.ViewDomain;
import lombok.Data;

/**
 * @author syj
 */
@Data
@Table(name = "food_procurement_bf")
public class FoodProcurementBf implements ViewDomain {

    private static final long serialVersionUID = -2155028381351648498L;
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
     * 食材ID
     */
    @Column(name = "food_id")
    private Long foodId;

    /**
     * 采购单价
     */
    @Column(name = "food_price")
    private Double foodPrice;

    /**
     * 采购数量
     */
    @Column(name = "food_count")
    private Double foodCount;

    /**
     * 创建时间
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
     * 食材名
     */
    @Column(name = "food_name")
    private String foodName;
}
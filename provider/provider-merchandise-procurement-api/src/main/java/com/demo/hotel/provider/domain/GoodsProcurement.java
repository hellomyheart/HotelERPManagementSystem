package com.demo.hotel.provider.domain;

import java.time.LocalDate;
import javax.persistence.*;

import com.demo.hotel.provider.doamin.TableDomain;
import lombok.Data;

/**
 * @author syj
 */
@Data
@Table(name = "goods_procurement")
public class GoodsProcurement  implements TableDomain {

    private static final long serialVersionUID = -3867966412690402094L;
    /**
     * ID
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
}
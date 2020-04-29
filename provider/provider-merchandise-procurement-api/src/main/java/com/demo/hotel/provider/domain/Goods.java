package com.demo.hotel.provider.domain;

import javax.persistence.*;

import com.demo.hotel.provider.doamin.TableDomain;
import lombok.Data;

/**
 * @author syj
 */
@Data
@Table(name = "goods")
public class Goods implements TableDomain {


    private static final long serialVersionUID = 4527405755781152829L;
    /**
     * 商品ID
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 商品条码
     */
    @Column(name = "goods_code")
    private String goodsCode;

    /**
     * 商品名
     */
    @Column(name = "goods_name")
    private String goodsName;

    /**
     * 图片
     */
    @Column(name = "picture")
    private String picture;

    /**
     * 商品类型
     */
    @Column(name = "type_id")
    private Long typeId;

    /**
     * 价格
     */
    @Column(name = "price")
    private Double price;

    /**
     * 库存数量
     */
    @Column(name = "goods_sum")
    private Double goodsSum;

    /**
     * 说明
     */
    @Column(name = "note")
    private String note;
}
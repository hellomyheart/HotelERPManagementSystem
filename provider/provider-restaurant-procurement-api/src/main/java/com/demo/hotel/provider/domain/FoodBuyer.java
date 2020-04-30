package com.demo.hotel.provider.domain;

import javax.persistence.*;

import com.demo.hotel.provider.doamin.TableDomain;
import lombok.Data;

/**
 * @author syj
 */
@Data
@Table(name = "food_buyer")
public class FoodBuyer implements TableDomain {

    private static final long serialVersionUID = -4478856998731757146L;
    /**
     * id
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 采购商名
     */
    @Column(name = "buyer_name")
    private String buyerName;

    /**
     * 公司名
     */
    @Column(name = "company")
    private String company;

    /**
     * 公司地址
     */
    @Column(name = "company_add")
    private String companyAdd;
}
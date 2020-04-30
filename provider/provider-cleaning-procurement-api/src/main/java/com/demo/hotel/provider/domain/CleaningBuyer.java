package com.demo.hotel.provider.domain;

import javax.persistence.*;

import com.demo.hotel.provider.doamin.TableDomain;
import lombok.Data;

@Data
@Table(name = "cleaning_buyer")
public class CleaningBuyer implements TableDomain {

    private static final long serialVersionUID = -3961212530923458969L;
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
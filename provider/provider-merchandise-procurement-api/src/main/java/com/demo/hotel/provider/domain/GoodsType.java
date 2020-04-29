package com.demo.hotel.provider.domain;

import javax.persistence.*;

import com.demo.hotel.provider.doamin.TableDomain;
import lombok.Data;

@Data
@Table(name = "goods_type")
public class GoodsType implements TableDomain {

    private static final long serialVersionUID = 9188543856168789282L;
    /**
     * ID
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 分类名
     */
    @Column(name = "type_name")
    private String typeName;
}
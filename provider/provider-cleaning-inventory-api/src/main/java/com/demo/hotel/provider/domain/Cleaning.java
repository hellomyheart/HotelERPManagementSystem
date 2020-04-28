package com.demo.hotel.provider.domain;

import javax.persistence.*;

import com.demo.hotel.provider.doamin.TableDomain;
import lombok.Data;

/**
 * @author syj
 */
@Data
@Table(name = "cleaning")
public class Cleaning implements TableDomain {

    private static final long serialVersionUID = 5868917380540619322L;
    /**
     * id
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 分类
     */
    @Column(name = "type_id")
    private Long typeId;

    /**
     * 用品名
     */
    @Column(name = "cleaning_name")
    private String cleaningName;

    /**
     * 数量
     */
    @Column(name = "cleaning_number")
    private Double cleaningNumber;

    /**
     * 备注
     */
    @Column(name = "note")
    private String note;
}
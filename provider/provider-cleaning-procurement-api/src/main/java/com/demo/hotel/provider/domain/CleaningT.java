package com.demo.hotel.provider.domain;

import javax.persistence.*;

import com.demo.hotel.provider.doamin.ViewDomain;
import lombok.Data;

/**
 * @author syj
 */
@Data
@Table(name = "cleaning_t")
public class CleaningT implements ViewDomain {

    private static final long serialVersionUID = 8962958191919009212L;
    /**
     * id
     */
    @Column(name = "id")
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

    /**
     * 分类名
     */
    @Column(name = "type_name")
    private String typeName;
}
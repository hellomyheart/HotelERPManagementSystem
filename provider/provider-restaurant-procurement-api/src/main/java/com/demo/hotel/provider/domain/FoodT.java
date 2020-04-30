package com.demo.hotel.provider.domain;

import javax.persistence.*;

import com.demo.hotel.provider.doamin.ViewDomain;
import lombok.Data;

/**
 * @author syj
 */
@Data
@Table(name = "food_t")
public class FoodT implements ViewDomain {

    private static final long serialVersionUID = 5280799467454067013L;
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
     * 食材名
     */
    @Column(name = "food_name")
    private String foodName;

    /**
     * 数量
     */
    @Column(name = "food_number")
    private Integer foodNumber;

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
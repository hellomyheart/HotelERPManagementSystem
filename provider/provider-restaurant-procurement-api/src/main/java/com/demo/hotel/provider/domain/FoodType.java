package com.demo.hotel.provider.domain;

import javax.persistence.*;

import com.demo.hotel.provider.doamin.TableDomain;
import lombok.Data;

/**
 * @author syj
 */
@Data
@Table(name = "food_type")
public class FoodType implements TableDomain {

    private static final long serialVersionUID = 8196806557650970038L;
    /**
     * id
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
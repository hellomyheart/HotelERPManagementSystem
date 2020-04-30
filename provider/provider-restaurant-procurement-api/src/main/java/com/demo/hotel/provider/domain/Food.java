package com.demo.hotel.provider.domain;

import javax.persistence.*;

import com.demo.hotel.provider.doamin.TableDomain;
import lombok.Data;

/**
 * @author syj
 */
@Data
@Table(name = "food")
public class Food  implements TableDomain {

    private static final long serialVersionUID = 6352851834504918293L;
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
}
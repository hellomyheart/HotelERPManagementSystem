package com.demo.hotel.provider.domain;

import javax.persistence.*;

import com.demo.hotel.provider.doamin.TableDomain;
import lombok.Data;

/**
 * @author syj
 */
@Data
@Table(name = "room_type")
public class RoomType implements TableDomain {
    /**
     * id
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 类型名
     */
    @Column(name = "type_name")
    private String typeName;

    /**
     * 图片
     */
    @Column(name = "picture")
    private String picture;

    /**
     * 描述
     */
    @Column(name = "note")
    private String note;

    /**
     * 价格
     */
    @Column(name = "price")
    private Double price;

    /**
     * 押金
     */
    @Column(name = "deposit")
    private Double deposit;

    /**
     * 床位数
     */
    @Column(name = "bed_count")
    private Integer bedCount;

    /**
     * 房间数
     */
    @Column(name = "room_count")
    private Integer roomCount;
}
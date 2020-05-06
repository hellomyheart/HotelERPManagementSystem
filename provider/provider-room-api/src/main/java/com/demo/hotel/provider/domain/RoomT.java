package com.demo.hotel.provider.domain;

import javax.persistence.*;

import com.demo.hotel.provider.doamin.ViewDomain;
import lombok.Data;

/**
 * @author syj
 */
@Data
@Table(name = "room_t")
public class RoomT implements ViewDomain {

    private static final long serialVersionUID = -6408459443670708804L;

    /**
     * 客房id
     */
    @Column(name = "id")
    private Long id;

    /**
     * 客房状态 0,未开放，1客满，2可以入住
     */
    @Column(name = "`status`")
    private Integer status;

    /**
     * 位置
     */
    @Column(name = "`location`")
    private String location;

    /**
     * 客房类型ID
     */
    @Column(name = "type_id")
    private Long typeId;

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

}
package com.demo.hotel.provider.domain;

import java.util.Date;
import javax.persistence.*;

import com.demo.hotel.provider.doamin.TableDomain;
import lombok.Data;

@Data
@Table(name = "room_order")
public class RoomOrder implements TableDomain {

    private static final long serialVersionUID = -2630164699021855524L;
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 客房ID
     */
    @Column(name = "room_id")
    private Long roomId;

    /**
     * 押金状态，0未付，1已付，2已退
     */
    @Column(name = "deposit_status")
    private Integer depositStatus;

    /**
     * 押金
     */
    @Column(name = "deposit_price")
    private Double depositPrice;

    /**
     * 订单状态，0未付，1已付
     */
    @Column(name = "order_status")
    private Integer orderStatus;

    /**
     * 创建时间
     */
    @Column(name = "creat_time")
    private Date creatTime;

    /**
     * 价格
     */
    @Column(name = "price")
    private Double price;

    /**
     * 入住时间
     */
    @Column(name = "check_in")
    private Date checkIn;

    /**
     * 天数
     */
    @Column(name = "`days`")
    private Integer days;
}
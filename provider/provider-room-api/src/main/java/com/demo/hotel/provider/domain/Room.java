package com.demo.hotel.provider.domain;

import javax.persistence.*;

import com.demo.hotel.provider.api.BaseSingleTableApi;
import com.demo.hotel.provider.doamin.TableDomain;
import lombok.Data;

@Data
@Table(name = "room")
public class Room  implements TableDomain {

    private static final long serialVersionUID = 8270353720504636202L;
    /**
     * 客房id
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
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
}
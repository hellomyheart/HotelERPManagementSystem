package com.demo.hotel.provider.domain;

import java.util.Date;
import javax.persistence.*;

import com.demo.hotel.provider.doamin.TableDomain;
import lombok.Data;

/**
 * @author syj
 */
@Data
@Table(name = "inspection")
public class Inspection implements TableDomain {

    private static final long serialVersionUID = 3694113424052214883L;
    /**
     * ID
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 客房ID
     */
    @Column(name = "room_id")
    private Long roomId;

    /**
     * 检修时间
     */
    @Column(name = "inspection_time")
    private Date inspectionTime;

    /**
     * 备注
     */
    @Column(name = "note")
    private String note;
}
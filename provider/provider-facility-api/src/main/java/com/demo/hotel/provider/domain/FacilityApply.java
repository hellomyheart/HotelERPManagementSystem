package com.demo.hotel.provider.domain;

import java.util.Date;
import javax.persistence.*;

import com.demo.hotel.provider.doamin.TableDomain;
import lombok.Data;

/**
 * @author syj
 */
@Data
@Table(name = "facility_apply")
public class FacilityApply implements TableDomain {

    private static final long serialVersionUID = -1169027591319668306L;
    /**
     * ID
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 标题
     */
    @Column(name = "title")
    private String title;

    /**
     * 申请时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 单价
     */
    @Column(name = "price")
    private Double price;

    /**
     * 单位
     */
    @Column(name = "unit")
    private String unit;

    /**
     * 数量
     */
    @Column(name = "quantity")
    private Double quantity;

    /**
     * 总价
     */
    @Column(name = "total_price")
    private Double totalPrice;

    /**
     * 详细情况
     */
    @Column(name = "note")
    private String note;

    /**
     * 申请人
     */
    @Column(name = "apply_id")
    private Long applyId;

    /**
     * 状态,0申请，1通过
     */
    @Column(name = "`status`")
    private Integer status;
}
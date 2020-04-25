package com.demo.hotel.provider.domain;

import java.util.Date;
import javax.persistence.*;

import com.demo.hotel.provider.doamin.ViewDomain;
import lombok.Data;

/**
 * @author syj
 */
@Data
@Table(name = "facility_apply_e")
public class FacilityApplyE implements ViewDomain {

    private static final long serialVersionUID = 9209741843218808892L;
    /**
     * ID
     */
    @Column(name = "id")
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

    /**
     * 职工姓名
     */
    @Column(name = "employee_name")
    private String employeeName;
}
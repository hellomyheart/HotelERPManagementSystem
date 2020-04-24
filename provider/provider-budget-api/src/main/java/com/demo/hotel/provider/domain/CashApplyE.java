package com.demo.hotel.provider.domain;

import java.util.Date;
import javax.persistence.*;

import com.demo.hotel.provider.doamin.ViewDomain;
import lombok.Data;

@Data
@Table(name = "cash_apply_e")
public class CashApplyE implements ViewDomain {


    private static final long serialVersionUID = -2421835361448889374L;

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
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 资金
     */
    @Column(name = "price")
    private Double price;

    /**
     * 说明
     */
    @Column(name = "note")
    private String note;

    /**
     * 申请人
     */
    @Column(name = "apply_id")
    private Long applyId;

    /**
     * 状态，0申请，1通过
     */
    @Column(name = "`status`")
    private Integer status;

    /**
     * 职工姓名
     */
    @Column(name = "employee_name")
    private String employeeName;
}
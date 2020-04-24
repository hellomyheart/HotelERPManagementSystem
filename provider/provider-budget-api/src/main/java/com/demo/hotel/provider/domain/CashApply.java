package com.demo.hotel.provider.domain;

import java.util.Date;
import javax.persistence.*;

import com.demo.hotel.provider.doamin.TableDomain;
import lombok.Data;

/**
 * @author syj
 */
@Data
@Table(name = "cash_apply")
public class CashApply implements TableDomain {


    private static final long serialVersionUID = 4316058344783231763L;
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
}
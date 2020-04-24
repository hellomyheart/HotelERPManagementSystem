package com.demo.hotel.provider.domain;

import java.io.Serializable;
import javax.persistence.*;

import com.demo.hotel.provider.doamin.TableDomain;
import lombok.Data;

@Data
@Table(name = "cash_flow")
public class CashFlow implements TableDomain {


    private static final long serialVersionUID = 6568108836666125231L;
    /**
     * ID
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 流动类型,0出，1入
     */
    @Column(name = "flow_type")
    private Integer flowType;

    /**
     * 金额
     */
    @Column(name = "money")
    private Double money;

    /**
     * 备注
     */
    @Column(name = "note")
    private String note;

}
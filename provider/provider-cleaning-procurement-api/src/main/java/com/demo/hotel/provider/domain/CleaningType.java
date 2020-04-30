package com.demo.hotel.provider.domain;

import javax.persistence.*;

import com.demo.hotel.provider.doamin.TableDomain;
import lombok.Data;

/**
 * @author syj
 */
@Data
@Table(name = "cleaning_type")
public class CleaningType implements TableDomain {

    private static final long serialVersionUID = -7742272740292582820L;
    /**
     * ID
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 分类名
     */
    @Column(name = "type_name")
    private String typeName;
}
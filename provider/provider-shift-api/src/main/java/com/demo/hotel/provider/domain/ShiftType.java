package com.demo.hotel.provider.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "shift_type")
public class ShiftType implements Serializable {
    private static final long serialVersionUID = -1908286967274474900L;
    /**
     * 分类ID
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

    /**
     * 部门ID
     */
    @Column(name = "department_id")
    private Long departmentId;

}
package com.demo.hotel.provider.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "admin_login_log")
public class AdminLoginLog implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    @Column(name = "admin_id")
    private Long adminId;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "ip")
    private String ip;

    @Column(name = "address")
    private String address;

    /**
     * 浏览器登录类型
     */
    @Column(name = "user_agent")
    private String userAgent;

    private static final long serialVersionUID = 2167884012793129661L;
}
package com.demo.hotel.cloud.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: HotelERPManagementSystem
 * @description: admin登录日志dto
 * @author: syj
 * @create: 2020-03-31 22:24
 **/
@Data
public class AdminLoginLogDTO implements Serializable {
    private static final long serialVersionUID = 6877723335733106853L;
    private Long id;
    private Long adminId;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private String ip;
    private String address;
    private String userAgent;
}
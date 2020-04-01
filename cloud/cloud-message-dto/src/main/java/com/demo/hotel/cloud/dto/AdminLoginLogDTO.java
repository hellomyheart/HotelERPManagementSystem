package com.demo.hotel.cloud.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author syj
 */
@Data
public class AdminLoginLogDTO implements Serializable {

    private static final long serialVersionUID = 3606920112072238956L;
    private Long id;
    private Long adminId;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private String ip;
    private String address;
    private String userAgent;
}

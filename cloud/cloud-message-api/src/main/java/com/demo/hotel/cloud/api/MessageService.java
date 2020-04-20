package com.demo.hotel.cloud.api;

import com.demo.hotel.cloud.dto.AdminLoginLogDTO;
import com.demo.hotel.cloud.dto.UserCodeDTO;

/**
 * @author syj
 */
public interface MessageService {

    /**
     * 发送登录日志消息
     * @param umsAdminLoginLogDTO
     * @return
     */
    boolean sendAdminLoginLog(AdminLoginLogDTO umsAdminLoginLogDTO);

    /**
     * 发送用户注册验证码消息
     * @param userCodeDTO
     * @return
     */
    boolean sendUserCode(UserCodeDTO userCodeDTO);

}

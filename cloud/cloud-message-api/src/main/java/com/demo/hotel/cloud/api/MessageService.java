package com.demo.hotel.cloud.api;

import com.demo.hotel.cloud.dto.AdminLoginLogDTO;

/**
 * @author syj
 */
public interface MessageService {

    boolean sendAdminLoginLog(AdminLoginLogDTO umsAdminLoginLogDTO);

}

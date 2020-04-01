package com.demo.hotel.cloud.api;

import com.demo.hotel.cloud.dto.AdminLoginLogDTO;

/**
 * @program: HotelERPManagementSystem
 * @description: 消息服务api
 * @author: syj
 * @create: 2020-03-31 22:22
 **/
public interface MessageService {
    boolean sendAdminLoginLog(AdminLoginLogDTO adminLoginLogDTO);

}

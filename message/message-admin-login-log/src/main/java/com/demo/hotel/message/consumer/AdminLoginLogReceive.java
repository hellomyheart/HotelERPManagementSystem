package com.demo.hotel.message.consumer;

import com.demo.hotel.commons.utils.MapperUtils;
import com.demo.hotel.provider.api.AdminLoginLogService;
import com.demo.hotel.provider.domain.AdminLoginLog;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

/**
 * @author syj
 */
@Service
public class AdminLoginLogReceive {

    @Reference(version = "1.0.0")
    private AdminLoginLogService adminLoginLogService;

    @StreamListener("admin-login-log-topic")
    public void receiveAdminLoginLog(String umsAdminLoginLogJson) throws Exception {
        AdminLoginLog umsAdminLoginLog = MapperUtils.json2pojo(umsAdminLoginLogJson, AdminLoginLog.class);
        adminLoginLogService.insert(umsAdminLoginLog);
    }

}

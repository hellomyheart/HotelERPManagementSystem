package com.demo.hotel.provider.api;

import com.demo.hotel.provider.domain.AdminLoginLog;

public interface AdminLoginLogService{

    /**
     * 新增日志
     *
     * @param adminLoginLog {@link AdminLoginLog}
     * @return {@code int} 大于 0 则表示添加成功
     */
    int insert(AdminLoginLog adminLoginLog);
}

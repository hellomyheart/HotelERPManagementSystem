package com.demo.hotel.provider.service;

import com.demo.hotel.provider.domain.AdminLoginLog;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.demo.hotel.provider.mapper.AdminLoginLogMapper;
import com.demo.hotel.provider.api.AdminLoginLogService;
@Service
public class AdminLoginLogServiceImpl implements AdminLoginLogService{

    @Resource
    private AdminLoginLogMapper adminLoginLogMapper;

    @Override
    public int insert(AdminLoginLog adminLoginLog) {
        return adminLoginLogMapper.insert(adminLoginLog);
    }
}

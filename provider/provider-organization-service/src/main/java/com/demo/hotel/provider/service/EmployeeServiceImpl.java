package com.demo.hotel.provider.service;

import javax.annotation.Resource;
import com.demo.hotel.provider.mapper.EmployeeMapper;
import com.demo.hotel.provider.api.EmployeeService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class EmployeeServiceImpl implements EmployeeService{

    @Resource
    private EmployeeMapper employeeMapper;

}

package com.demo.hotel.provider.service;

import com.demo.hotel.provider.domain.EmployeeP;

import javax.annotation.Resource;
import com.demo.hotel.provider.mapper.EmployeePMapper;
import com.demo.hotel.provider.api.EmployeePService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

/**
 * @author syj
 */
@Service(version = "1.0.0")
public class EmployeePServiceImpl implements EmployeePService{

    @Resource
    private EmployeePMapper employeePMapper;

    @Override
    public List<EmployeeP> selectAll() {
        return employeePMapper.selectAll();
    }
}

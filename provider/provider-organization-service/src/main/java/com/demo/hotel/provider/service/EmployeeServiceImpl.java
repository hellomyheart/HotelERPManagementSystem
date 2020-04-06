package com.demo.hotel.provider.service;

import com.demo.hotel.provider.domain.Employee;

import javax.annotation.Resource;
import com.demo.hotel.provider.mapper.EmployeeMapper;
import com.demo.hotel.provider.api.EmployeeService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author syj
 */
@Service(version = "1.0.0")
public class EmployeeServiceImpl implements EmployeeService{

    @Resource
    private EmployeeMapper employeeMapper;

    @Override
    public int insert(Employee employee) {
        return employeeMapper.insert(employee);
    }

    @Override
    public int update(Employee employee) {
        return employeeMapper.updateByPrimaryKey(employee);
    }

    @Override
    public int delete(Long id) {
        return employeeMapper.deleteByPrimaryKey(id);
    }
}

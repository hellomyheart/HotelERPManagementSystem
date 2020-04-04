package com.demo.hotel.provider.service;

import com.demo.hotel.provider.domain.Department;

import javax.annotation.Resource;
import com.demo.hotel.provider.mapper.DepartmentMapper;
import com.demo.hotel.provider.api.DepartmentService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

/**
 * @author syj
 */
@Service(version = "1.0.0")
public class DepartmentServiceImpl implements DepartmentService{

    @Resource
    private DepartmentMapper departmentMapper;

    @Override
    public int insert(Department department) {
        return departmentMapper.insert(department);
    }

    @Override
    public int update(Department department) {
        return departmentMapper.updateByPrimaryKey(department);
    }

    @Override
    public int delete(Long id) {
        return departmentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Department> selectAll() {
        return departmentMapper.selectAll();
    }
}

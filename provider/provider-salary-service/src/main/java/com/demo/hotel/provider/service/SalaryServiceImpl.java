package com.demo.hotel.provider.service;

import com.demo.hotel.provider.domain.Salary;

import javax.annotation.Resource;
import com.demo.hotel.provider.mapper.SalaryMapper;
import com.demo.hotel.provider.api.SalaryService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author syj
 */
@Service(version = "1.0.0")
public class SalaryServiceImpl implements SalaryService{

    @Resource
    private SalaryMapper salaryMapper;

    @Override
    public int insert(Salary domain) {
        return salaryMapper.insert(domain);
    }

    //没有update
    @Override
    public int update(Salary domain) {
        return 0;
    }

    @Override
    public int delete(Long id) {
        return salaryMapper.deleteByPrimaryKey(id);
    }
}

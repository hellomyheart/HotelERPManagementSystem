package com.demo.hotel.provider.service;

import com.demo.hotel.provider.domain.SalaryE;

import javax.annotation.Resource;
import com.demo.hotel.provider.mapper.SalaryEMapper;
import com.demo.hotel.provider.api.SalaryEService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

/**
 * @author syj
 */
@Service(version = "1.0.0")
public class SalaryEServiceImpl implements SalaryEService{

    @Resource
    private SalaryEMapper salaryEMapper;

    @Override
    public List<SalaryE> selectAll() {
        return salaryEMapper.selectAll();
    }
}

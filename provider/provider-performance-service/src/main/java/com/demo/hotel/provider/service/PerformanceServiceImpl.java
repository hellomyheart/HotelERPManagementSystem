package com.demo.hotel.provider.service;

import javax.annotation.Resource;

import com.demo.hotel.provider.domain.Performance;
import com.demo.hotel.provider.mapper.PerformanceMapper;
import com.demo.hotel.provider.api.PerformanceService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author syj
 */
@Service(version = "1.0.0")
public class PerformanceServiceImpl implements PerformanceService{

    @Resource
    private PerformanceMapper performanceMapper;

    @Override
    public int insert(Performance domain) {
        return performanceMapper.insert(domain);
    }

    @Override
    public int update(Performance domain) {
        return performanceMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int delete(Long id) {
        return performanceMapper.deleteByPrimaryKey(id);
    }
}

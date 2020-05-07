package com.demo.hotel.provider.service;

import javax.annotation.Resource;

import com.demo.hotel.provider.domain.PerformanceE;
import com.demo.hotel.provider.mapper.PerformanceEMapper;
import com.demo.hotel.provider.api.PerformanceEService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

/**
 * @author syj
 */
@Service(version = "1.0.0")
public class PerformanceEServiceImpl implements PerformanceEService{

    @Resource
    private PerformanceEMapper performanceEMapper;

    @Override
    public List<PerformanceE> selectAll() {
        return performanceEMapper.selectAll();
    }
}

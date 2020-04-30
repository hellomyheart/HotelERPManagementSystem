package com.demo.hotel.provider.service;

import javax.annotation.Resource;

import com.demo.hotel.provider.domain.CleaningProcurement;
import com.demo.hotel.provider.mapper.CleaningProcurementMapper;
import com.demo.hotel.provider.api.CleaningProcurementService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class CleaningProcurementServiceImpl implements CleaningProcurementService{

    @Resource
    private CleaningProcurementMapper cleaningProcurementMapper;

    @Override
    public int insert(CleaningProcurement domain) {
        return cleaningProcurementMapper.insert(domain);
    }

    @Override
    public int update(CleaningProcurement domain) {
        return cleaningProcurementMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int delete(Long id) {
        return cleaningProcurementMapper.deleteByPrimaryKey(id);
    }
}

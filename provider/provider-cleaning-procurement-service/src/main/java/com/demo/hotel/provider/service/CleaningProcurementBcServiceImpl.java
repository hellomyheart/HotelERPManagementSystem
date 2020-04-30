package com.demo.hotel.provider.service;

import javax.annotation.Resource;

import com.demo.hotel.provider.domain.CleaningProcurementBc;
import com.demo.hotel.provider.mapper.CleaningProcurementBcMapper;
import com.demo.hotel.provider.api.CleaningProcurementBcService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

/**
 * @author syj
 */
@Service(version = "1.0.0")
public class CleaningProcurementBcServiceImpl implements CleaningProcurementBcService{

    @Resource
    private CleaningProcurementBcMapper cleaningProcurementBcMapper;

    @Override
    public List<CleaningProcurementBc> selectAll() {
        return cleaningProcurementBcMapper.selectAll();
    }
}

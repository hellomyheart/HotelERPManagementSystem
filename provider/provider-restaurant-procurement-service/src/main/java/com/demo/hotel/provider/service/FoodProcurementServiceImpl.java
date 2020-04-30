package com.demo.hotel.provider.service;

import javax.annotation.Resource;

import com.demo.hotel.provider.domain.FoodProcurement;
import com.demo.hotel.provider.mapper.FoodProcurementMapper;
import com.demo.hotel.provider.api.FoodProcurementService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class FoodProcurementServiceImpl implements FoodProcurementService{

    @Resource
    private FoodProcurementMapper foodProcurementMapper;

    @Override
    public int insert(FoodProcurement domain) {
        return foodProcurementMapper.insert(domain);
    }

    @Override
    public int update(FoodProcurement domain) {
        return foodProcurementMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int delete(Long id) {
        return foodProcurementMapper.deleteByPrimaryKey(id);
    }
}

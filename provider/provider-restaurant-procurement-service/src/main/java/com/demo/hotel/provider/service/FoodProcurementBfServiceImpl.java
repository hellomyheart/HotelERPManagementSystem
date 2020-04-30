package com.demo.hotel.provider.service;

import javax.annotation.Resource;

import com.demo.hotel.provider.domain.FoodProcurementBf;
import com.demo.hotel.provider.mapper.FoodProcurementBfMapper;
import com.demo.hotel.provider.api.FoodProcurementBfService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

/**
 * @author syj
 */
@Service(version = "1.0.0")
public class FoodProcurementBfServiceImpl implements FoodProcurementBfService{

    @Resource
    private FoodProcurementBfMapper foodProcurementBfMapper;

    @Override
    public List<FoodProcurementBf> selectAll() {
        return foodProcurementBfMapper.selectAll();
    }
}

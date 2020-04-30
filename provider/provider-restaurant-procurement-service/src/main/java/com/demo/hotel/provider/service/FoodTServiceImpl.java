package com.demo.hotel.provider.service;

import javax.annotation.Resource;

import com.demo.hotel.provider.domain.FoodT;
import com.demo.hotel.provider.mapper.FoodTMapper;
import com.demo.hotel.provider.api.FoodTService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

/**
 * @author syj
 */
@Service(version = "1.0.0")
public class FoodTServiceImpl implements FoodTService{

    @Resource
    private FoodTMapper foodTMapper;

    @Override
    public List<FoodT> selectAll() {
        return foodTMapper.selectAll();
    }
}

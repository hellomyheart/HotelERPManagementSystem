package com.demo.hotel.provider.service;

import javax.annotation.Resource;

import com.demo.hotel.provider.domain.FoodBuyer;
import com.demo.hotel.provider.mapper.FoodBuyerMapper;
import com.demo.hotel.provider.api.FoodBuyerService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

/**
 * @author syj
 */
@Service(version = "1.0.0")
public class FoodBuyerServiceImpl implements FoodBuyerService{

    @Resource
    private FoodBuyerMapper foodBuyerMapper;

    @Override
    public int insert(FoodBuyer domain) {
        return foodBuyerMapper.insert(domain);
    }

    @Override
    public int update(FoodBuyer domain) {
        return foodBuyerMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int delete(Long id) {
        return foodBuyerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<FoodBuyer> selectAll() {
        return foodBuyerMapper.selectAll();
    }
}

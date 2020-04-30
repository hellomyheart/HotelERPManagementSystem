package com.demo.hotel.provider.service;

import javax.annotation.Resource;

import com.demo.hotel.provider.domain.Food;
import com.demo.hotel.provider.mapper.FoodMapper;
import com.demo.hotel.provider.api.FoodPService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author syj
 */
@Service(version = "1.0.0")
public class FoodServiceImpl implements FoodPService {

    @Resource
    private FoodMapper foodMapper;

    @Override
    public int insert(Food domain) {
        return foodMapper.insert(domain);
    }

    @Override
    public int update(Food domain) {
        return foodMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int delete(Long id) {
        return foodMapper.deleteByPrimaryKey(id);
    }
}

package com.demo.hotel.provider.service;

import com.demo.hotel.provider.domain.Food;

import javax.annotation.Resource;
import com.demo.hotel.provider.mapper.FoodMapper;
import com.demo.hotel.provider.api.FoodService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

/**
 * @author syj
 */
@Service(version = "1.0.0")
public class FoodServiceImpl implements FoodService{

    @Resource
    private FoodMapper foodMapper;


    @Override
    public int insert(Food domain) {
        return 0;
    }

    @Override
    public int update(Food domain) {
        Food food=new Food();
        food.setId(domain.getId());
        food.setFoodNumber(domain.getFoodNumber());
        return foodMapper.updateByPrimaryKeySelective(food);
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public List<Food> selectAll() {
        return foodMapper.selectAll();
    }
}
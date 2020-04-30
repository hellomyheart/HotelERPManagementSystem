package com.demo.hotel.provider.service;

import javax.annotation.Resource;

import com.demo.hotel.provider.domain.FoodType;
import com.demo.hotel.provider.mapper.FoodTypeMapper;
import com.demo.hotel.provider.api.FoodTypeService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

/**
 * @author syj
 */
@Service(version = "1.0.0")
public class FoodTypeServiceImpl implements FoodTypeService{

    @Resource
    private FoodTypeMapper foodTypeMapper;

    @Override
    public int insert(FoodType domain) {
        return foodTypeMapper.insert(domain);
    }

    @Override
    public int update(FoodType domain) {
        return foodTypeMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int delete(Long id) {
        return foodTypeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<FoodType> selectAll() {
        return foodTypeMapper.selectAll();
    }
}

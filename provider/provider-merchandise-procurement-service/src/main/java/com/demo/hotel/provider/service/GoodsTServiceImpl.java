package com.demo.hotel.provider.service;

import com.demo.hotel.provider.domain.GoodsT;

import javax.annotation.Resource;
import com.demo.hotel.provider.mapper.GoodsTMapper;
import com.demo.hotel.provider.api.GoodsTService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

/**
 * @author syj
 * 商品视图
 */
@Service(version = "1.0.0")
public class GoodsTServiceImpl implements GoodsTService{

    @Resource
    private GoodsTMapper goodsTMapper;

    @Override
    public List<GoodsT> selectAll() {
        return goodsTMapper.selectAll();
    }
}

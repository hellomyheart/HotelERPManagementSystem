package com.demo.hotel.provider.service;

import com.demo.hotel.provider.domain.GoodsBuyer;

import javax.annotation.Resource;
import com.demo.hotel.provider.mapper.GoodsBuyerMapper;
import com.demo.hotel.provider.api.GoodsBuyerService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

/**
 * @author syj
 * 采购商管理
 */
@Service(version = "1.0.0")
public class GoodsBuyerServiceImpl implements GoodsBuyerService{

    @Resource
    private GoodsBuyerMapper goodsBuyerMapper;

    @Override
    public int insert(GoodsBuyer domain) {
        return goodsBuyerMapper.insert(domain);
    }

    @Override
    public int update(GoodsBuyer domain) {
        return goodsBuyerMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int delete(Long id) {
        return goodsBuyerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<GoodsBuyer> selectAll() {
        return goodsBuyerMapper.selectAll();
    }
}

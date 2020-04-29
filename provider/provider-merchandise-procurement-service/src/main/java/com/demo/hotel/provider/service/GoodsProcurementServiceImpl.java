package com.demo.hotel.provider.service;

import com.demo.hotel.provider.domain.GoodsProcurement;

import javax.annotation.Resource;
import com.demo.hotel.provider.mapper.GoodsProcurementMapper;
import com.demo.hotel.provider.api.GoodsProcurementService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author syj
 * 商品采购
 */
@Service(version = "1.0.0")
public class GoodsProcurementServiceImpl implements GoodsProcurementService{

    @Resource
    private GoodsProcurementMapper goodsProcurementMapper;

    @Override
    public int insert(GoodsProcurement domain) {
        return goodsProcurementMapper.insert(domain);
    }

    @Override
    public int update(GoodsProcurement domain) {
        return goodsProcurementMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int delete(Long id) {
        return goodsProcurementMapper.deleteByPrimaryKey(id);
    }
}

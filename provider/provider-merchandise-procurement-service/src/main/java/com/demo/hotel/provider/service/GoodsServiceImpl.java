package com.demo.hotel.provider.service;

import com.demo.hotel.provider.domain.Goods;

import javax.annotation.Resource;
import com.demo.hotel.provider.mapper.GoodsMapper;
import com.demo.hotel.provider.api.GoodsPService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author syj
 * 商品管理
 */
@Service(version = "1.0.0")
public class GoodsServiceImpl implements GoodsPService {

    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public int insert(Goods domain) {
        return goodsMapper.insert(domain);
    }

    @Override
    public int update(Goods domain) {
        return goodsMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int delete(Long id) {
        return goodsMapper.deleteByPrimaryKey(id);
    }
}

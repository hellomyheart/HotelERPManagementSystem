package com.demo.hotel.provider.service;

import com.demo.hotel.provider.domain.Goods;

import javax.annotation.Resource;

import com.demo.hotel.provider.mapper.GoodsMapper;
import com.demo.hotel.provider.api.GoodsService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

@Service(version = "1.0.0")
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    //不支持新增与删除，只有采购部门支持
    @Override
    public int insert(Goods domain) {
        return 0;
    }

    @Override
    public int update(Goods domain) {
        Goods goods = new Goods();
        goods.setId(domain.getId());
        goods.setGoodsSum(domain.getGoodsSum());
        return goodsMapper.updateByPrimaryKeySelective(goods);

    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public List<Goods> selectAll() {
        return goodsMapper.selectAll();
    }
}

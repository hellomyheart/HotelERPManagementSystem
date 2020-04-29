package com.demo.hotel.provider.service;

import com.demo.hotel.provider.domain.GoodsType;

import javax.annotation.Resource;
import com.demo.hotel.provider.mapper.GoodsTypeMapper;
import com.demo.hotel.provider.api.GoodsTypeService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

/**
 * @author syj
 * 商品分类
 */
@Service(version = "1.0.0")
public class GoodsTypeServiceImpl implements GoodsTypeService{

    @Resource
    private GoodsTypeMapper goodsTypeMapper;

    @Override
    public int insert(GoodsType domain) {
        return goodsTypeMapper.insert(domain);
    }

    @Override
    public int update(GoodsType domain) {
        return goodsTypeMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int delete(Long id) {
        return goodsTypeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<GoodsType> selectAll() {
        return goodsTypeMapper.selectAll();
    }
}

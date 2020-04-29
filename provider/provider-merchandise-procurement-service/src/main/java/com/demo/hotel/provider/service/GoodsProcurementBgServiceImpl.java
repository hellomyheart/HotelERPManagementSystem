package com.demo.hotel.provider.service;

import com.demo.hotel.provider.domain.GoodsProcurementBg;

import javax.annotation.Resource;
import com.demo.hotel.provider.mapper.GoodsProcurementBgMapper;
import com.demo.hotel.provider.api.GoodsProcurementBgService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

/**
 * @author syj
 * 商品采购视图
 */
@Service(version = "1.0.0")
public class GoodsProcurementBgServiceImpl implements GoodsProcurementBgService{

    @Resource
    private GoodsProcurementBgMapper goodsProcurementBgMapper;

    @Override
    public List<GoodsProcurementBg> selectAll() {
        return goodsProcurementBgMapper.selectAll();
    }
}

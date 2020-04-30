package com.demo.hotel.provider.service;

import javax.annotation.Resource;

import com.demo.hotel.provider.domain.CleaningBuyer;
import com.demo.hotel.provider.mapper.CleaningBuyerMapper;
import com.demo.hotel.provider.api.CleaningBuyerService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

/**
 * @author syj
 */
@Service(version = "1.0.0")
public class CleaningBuyerServiceImpl implements CleaningBuyerService{

    @Resource
    private CleaningBuyerMapper cleaningBuyerMapper;

    @Override
    public int insert(CleaningBuyer domain) {
        return cleaningBuyerMapper.insert(domain);
    }

    @Override
    public int update(CleaningBuyer domain) {
        return cleaningBuyerMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int delete(Long id) {
        return cleaningBuyerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<CleaningBuyer> selectAll() {
        return cleaningBuyerMapper.selectAll();
    }
}

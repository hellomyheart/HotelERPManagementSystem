package com.demo.hotel.provider.service;

import javax.annotation.Resource;

import com.demo.hotel.provider.domain.Cleaning;
import com.demo.hotel.provider.mapper.CleaningMapper;
import com.demo.hotel.provider.api.CleaningPService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author syj
 */
@Service(version = "1.0.0")
public class CleaningServiceImpl implements CleaningPService {

    @Resource
    private CleaningMapper cleaningMapper;

    @Override
    public int insert(Cleaning domain) {
        return cleaningMapper.insert(domain);
    }

    @Override
    public int update(Cleaning domain) {
        return cleaningMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int delete(Long id) {
        return cleaningMapper.deleteByPrimaryKey(id);
    }
}

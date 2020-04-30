package com.demo.hotel.provider.service;

import javax.annotation.Resource;

import com.demo.hotel.provider.domain.CleaningType;
import com.demo.hotel.provider.mapper.CleaningTypeMapper;
import com.demo.hotel.provider.api.CleaningTypeService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

/**
 * @author syj
 */
@Service(version = "1.0.0")
public class CleaningTypeServiceImpl implements CleaningTypeService {

    @Resource
    private CleaningTypeMapper cleaningTypeMapper;

    @Override
    public int insert(CleaningType domain) {
        return cleaningTypeMapper.insert(domain);
    }

    @Override
    public int update(CleaningType domain) {
        return cleaningTypeMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int delete(Long id) {
        return cleaningTypeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<CleaningType> selectAll() {
        return cleaningTypeMapper.selectAll();
    }
}

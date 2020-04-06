package com.demo.hotel.provider.service;

import javax.annotation.Resource;

import com.demo.hotel.provider.domain.Position;
import com.demo.hotel.provider.mapper.PositionMapper;
import com.demo.hotel.provider.api.PositionService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author syj
 */
@Service(version = "1.0.0")
public class PositionServiceImpl implements PositionService {

    @Resource
    private PositionMapper positionMapper;

    @Override
    public int insert(Position position) {
        return positionMapper.insert(position);
    }

    @Override
    public int update(Position position) {
        return positionMapper.updateByPrimaryKey(position);
    }

    @Override
    public int delete(Long id) {
        return positionMapper.deleteByPrimaryKey(id);
    }
}


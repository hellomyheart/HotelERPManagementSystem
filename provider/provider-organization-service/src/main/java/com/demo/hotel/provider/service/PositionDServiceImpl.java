package com.demo.hotel.provider.service;

import javax.annotation.Resource;

import com.demo.hotel.provider.domain.Position;
import com.demo.hotel.provider.domain.PositionD;
import com.demo.hotel.provider.mapper.PositionDMapper;
import com.demo.hotel.provider.api.PositionDService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

/**
 * @author syj
 */
@Service(version = "1.0.0")
public class PositionDServiceImpl implements PositionDService{

    @Resource
    private PositionDMapper positionDMapper;

    @Override
    public List<PositionD> selectAll() {
        return positionDMapper.selectAll();
    }

}

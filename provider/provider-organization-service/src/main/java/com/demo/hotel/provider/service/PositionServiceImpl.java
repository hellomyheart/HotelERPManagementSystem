package com.demo.hotel.provider.service;

import javax.annotation.Resource;
import com.demo.hotel.provider.mapper.PositionMapper;
import com.demo.hotel.provider.api.PositionService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author syj
 */
@Service(version = "1.0.0")
public class PositionServiceImpl implements PositionService{

    @Resource
    private PositionMapper positionMapper;

}

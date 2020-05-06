package com.demo.hotel.provider.service;

import com.demo.hotel.provider.domain.RoomT;

import javax.annotation.Resource;
import com.demo.hotel.provider.mapper.RoomTMapper;
import com.demo.hotel.provider.api.RoomTService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

/**
 * @author syj
 */
@Service(version = "1.0.0")
public class RoomTServiceImpl implements RoomTService{

    @Resource
    private RoomTMapper roomTMapper;

    @Override
    public List<RoomT> selectAll() {
        return roomTMapper.selectAll();
    }
}

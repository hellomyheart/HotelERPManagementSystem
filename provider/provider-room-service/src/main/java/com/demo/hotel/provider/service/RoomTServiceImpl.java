package com.demo.hotel.provider.service;

import com.demo.hotel.provider.domain.RoomT;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.demo.hotel.provider.mapper.RoomTMapper;
import com.demo.hotel.provider.api.RoomTService;

import java.util.List;

@Service
public class RoomTServiceImpl implements RoomTService{

    @Resource
    private RoomTMapper roomTMapper;

    @Override
    public List<RoomT> selectAll() {
        return roomTMapper.selectAll();
    }
}

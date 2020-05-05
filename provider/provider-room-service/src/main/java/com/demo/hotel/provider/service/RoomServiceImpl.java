package com.demo.hotel.provider.service;

import com.demo.hotel.provider.domain.Room;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.demo.hotel.provider.mapper.RoomMapper;
import com.demo.hotel.provider.api.RoomService;

import java.util.List;

/**
 * @author syj
 */
@Service
public class RoomServiceImpl implements RoomService{

    @Resource
    private RoomMapper roomMapper;

    @Override
    public int insert(Room domain) {
        return 0;
    }

    @Override
    public int update(Room domain) {
        return roomMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int delete(Long id) {
        return 0;
    }
}

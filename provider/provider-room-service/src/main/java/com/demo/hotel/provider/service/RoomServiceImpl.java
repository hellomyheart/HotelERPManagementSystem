package com.demo.hotel.provider.service;

import com.demo.hotel.provider.domain.Room;

import javax.annotation.Resource;
import com.demo.hotel.provider.mapper.RoomMapper;
import com.demo.hotel.provider.api.RoomService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

/**
 * @author syj
 */
@Service(version = "1.0.0")
public class RoomServiceImpl implements RoomService{

    @Resource
    private RoomMapper roomMapper;

    @Override
    public int insert(Room domain) {
        return roomMapper.insert(domain);
    }

    @Override
    public int update(Room domain) {
        return roomMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int delete(Long id) {
        return roomMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Room> selectAllRoom() {
        return roomMapper.selectAll();
    }

    @Override
    public Room getById(Long id) {
        return roomMapper.selectByPrimaryKey(id);
    }
}

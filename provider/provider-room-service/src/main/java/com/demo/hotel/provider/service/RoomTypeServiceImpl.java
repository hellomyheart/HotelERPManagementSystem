package com.demo.hotel.provider.service;

import com.demo.hotel.provider.domain.RoomType;

import javax.annotation.Resource;
import com.demo.hotel.provider.mapper.RoomTypeMapper;
import com.demo.hotel.provider.api.RoomTypeService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

/**
 * @author syj
 */
@Service(version = "1.0.0")
public class RoomTypeServiceImpl implements RoomTypeService{

    @Resource
    private RoomTypeMapper roomTypeMapper;

    @Override
    public int insert(RoomType domain) {
        domain.setRoomCount(0);
        return roomTypeMapper.insert(domain);
    }

    @Override
    public int update(RoomType domain) {
        return roomTypeMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int delete(Long id) {
        return roomTypeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<RoomType> selectAll() {
        return roomTypeMapper.selectAll();
    }

    @Override
    public RoomType getById(Long id) {
        return roomTypeMapper.selectByPrimaryKey(id);
    }
}

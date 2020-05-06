package com.demo.hotel.provider.service;

import com.demo.hotel.provider.domain.RoomOrder;

import javax.annotation.Resource;
import com.demo.hotel.provider.mapper.RoomOrderMapper;
import com.demo.hotel.provider.api.RoomOrderService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

/**
 * @author syj
 */
@Service(version = "1.0.0")
public class RoomOrderServiceImpl implements RoomOrderService{

    @Resource
    private RoomOrderMapper roomOrderMapper;

    @Override
    public int insert(RoomOrder domain) {
        return roomOrderMapper.insert(domain);
    }

    @Override
    public int update(RoomOrder domain) {
        return roomOrderMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int delete(Long id) {
        return roomOrderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<RoomOrder> selectAll() {
        return roomOrderMapper.selectAll();
    }
}

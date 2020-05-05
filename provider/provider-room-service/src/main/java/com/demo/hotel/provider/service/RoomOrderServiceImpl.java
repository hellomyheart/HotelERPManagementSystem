package com.demo.hotel.provider.service;

import com.demo.hotel.provider.domain.RoomOrder;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.demo.hotel.provider.mapper.RoomOrderMapper;
import com.demo.hotel.provider.api.RoomOrderService;

import java.util.List;

/**
 * @author syj
 */
@Service
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
        return 0;
    }

    @Override
    public List<RoomOrder> selectAll() {
        return roomOrderMapper.selectAll();
    }
}

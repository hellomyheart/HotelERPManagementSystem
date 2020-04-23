package com.demo.hotel.provider.service;

import javax.annotation.Resource;

import com.demo.hotel.provider.domain.Shift;
import com.demo.hotel.provider.mapper.ShiftMapper;
import com.demo.hotel.provider.api.ShiftService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author syj
 */
@Service(version = "1.0.0")
public class ShiftServiceImpl implements ShiftService{

    @Resource
    private ShiftMapper shiftMapper;

    @Override
    public int insert(Shift shift) {
        return shiftMapper.insert(shift);
    }

    @Override
    public int update(Shift shift) {
        return shiftMapper.updateByPrimaryKey(shift);
    }

    @Override
    public int delete(Long id) {
        return shiftMapper.deleteByPrimaryKey(id);
    }

}

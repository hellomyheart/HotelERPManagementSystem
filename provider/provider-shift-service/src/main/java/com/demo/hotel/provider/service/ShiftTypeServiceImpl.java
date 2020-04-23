package com.demo.hotel.provider.service;

import javax.annotation.Resource;

import com.demo.hotel.provider.domain.ShiftType;
import com.demo.hotel.provider.mapper.ShiftTypeMapper;
import com.demo.hotel.provider.api.ShiftTypeService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author syj
 */
@Service(version = "1.0.0")
public class ShiftTypeServiceImpl implements ShiftTypeService{

    @Resource
    private ShiftTypeMapper shiftTypeMapper;

    @Override
    public int insert(ShiftType shiftType) {
        return shiftTypeMapper.insert(shiftType);
    }

    @Override
    public int update(ShiftType shiftType) {
        return shiftTypeMapper.updateByPrimaryKey(shiftType);
    }

    @Override
    public int delete(Long id) {
        return shiftTypeMapper.deleteByPrimaryKey(id);
    }

}

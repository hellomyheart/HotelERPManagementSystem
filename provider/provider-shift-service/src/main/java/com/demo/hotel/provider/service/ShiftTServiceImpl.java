package com.demo.hotel.provider.service;

import javax.annotation.Resource;

import com.demo.hotel.provider.domain.ShiftT;
import com.demo.hotel.provider.mapper.ShiftTMapper;
import com.demo.hotel.provider.api.ShiftTService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

@Service(version = "1.0.0")
public class ShiftTServiceImpl implements ShiftTService{

    @Resource
    private ShiftTMapper shiftTMapper;

    @Override
    public List<ShiftT> selectAll() {
        return shiftTMapper.selectAll();
    }

}

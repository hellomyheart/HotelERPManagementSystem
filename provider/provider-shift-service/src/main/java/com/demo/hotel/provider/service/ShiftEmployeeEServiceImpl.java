package com.demo.hotel.provider.service;

import javax.annotation.Resource;

import com.demo.hotel.provider.domain.ShiftEmployeeE;
import com.demo.hotel.provider.mapper.ShiftEmployeeEMapper;
import com.demo.hotel.provider.api.ShiftEmployeeEService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

/**
 * @author syj
 */
@Service(version = "1.0.0")
public class ShiftEmployeeEServiceImpl implements ShiftEmployeeEService{

    @Resource
    private ShiftEmployeeEMapper shiftEmployeeEMapper;


    @Override
    public List<ShiftEmployeeE> selectAll() {
        return shiftEmployeeEMapper.selectAll();
    }
}

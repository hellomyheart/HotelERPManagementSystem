package com.demo.hotel.provider.service;

import javax.annotation.Resource;

import com.demo.hotel.provider.domain.ShiftEmployee;
import com.demo.hotel.provider.mapper.ShiftEmployeeMapper;
import com.demo.hotel.provider.api.ShiftEmployeeService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author syj
 */
@Service(version = "1.0.0")
public class ShiftEmployeeServiceImpl implements ShiftEmployeeService{

    @Resource
    private ShiftEmployeeMapper shiftEmployeeMapper;

    @Override
    public int insert(ShiftEmployee shiftEmployee) {
        return shiftEmployeeMapper.insert(shiftEmployee);
    }

    @Override
    public int update(ShiftEmployee shiftEmployee) {
        return shiftEmployeeMapper.updateByPrimaryKey(shiftEmployee);
    }

    @Override
    public int delete(Long id) {
        return shiftEmployeeMapper.deleteByPrimaryKey(id);
    }

}

package com.demo.hotel.provider.service;

import javax.annotation.Resource;

import com.demo.hotel.provider.domain.ShiftTypeD;
import com.demo.hotel.provider.mapper.ShiftTypeDMapper;
import com.demo.hotel.provider.api.ShiftTypeDService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

/**
 * @author syj
 */
@Service(version = "1.0.0")
public class ShiftTypeDServiceImpl implements ShiftTypeDService {

    @Resource
    private ShiftTypeDMapper shiftTypeDMapper;

    @Override
    public List<ShiftTypeD> selectAll() {
        return shiftTypeDMapper.selectAll();
    }
}

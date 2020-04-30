package com.demo.hotel.provider.service;

import javax.annotation.Resource;

import com.demo.hotel.provider.domain.CleaningT;
import com.demo.hotel.provider.mapper.CleaningTMapper;
import com.demo.hotel.provider.api.CleaningTService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

@Service(version = "1.0.0")
public class CleaningTServiceImpl implements CleaningTService{

    @Resource
    private CleaningTMapper cleaningTMapper;

    @Override
    public List<CleaningT> selectAll() {
        return cleaningTMapper.selectAll();
    }
}

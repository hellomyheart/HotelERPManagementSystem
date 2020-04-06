package com.demo.hotel.provider.service;

import javax.annotation.Resource;

import com.demo.hotel.provider.domain.TrainingContentP;
import com.demo.hotel.provider.mapper.TrainingContentPMapper;
import com.demo.hotel.provider.api.TrainingContentPService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

/**
 * @author syj
 */
@Service(version = "1.0.0")
public class TrainingContentPServiceImpl implements TrainingContentPService{

    @Resource
    private TrainingContentPMapper trainingContentPMapper;

    @Override
    public List<TrainingContentP> selectAll() {
        return trainingContentPMapper.selectAll();
    }
}

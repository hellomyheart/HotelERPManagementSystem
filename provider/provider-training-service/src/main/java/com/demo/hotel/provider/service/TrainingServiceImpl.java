package com.demo.hotel.provider.service;

import javax.annotation.Resource;

import com.demo.hotel.provider.domain.Training;
import com.demo.hotel.provider.mapper.TrainingMapper;
import com.demo.hotel.provider.api.TrainingService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author syj
 */
@Service(version = "1.0.0")
public class TrainingServiceImpl implements TrainingService{

    @Resource
    private TrainingMapper trainingMapper;

    @Override
    public int insert(Training training) {
        return trainingMapper.insert(training);
    }

    @Override
    public int update(Training training) {
        return trainingMapper.updateByPrimaryKey(training);
    }

    @Override
    public int delete(Long id) {
        return trainingMapper.deleteByPrimaryKey(id);
    }
}

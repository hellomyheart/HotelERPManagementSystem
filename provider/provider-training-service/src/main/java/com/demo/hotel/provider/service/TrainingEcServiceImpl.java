package com.demo.hotel.provider.service;

import javax.annotation.Resource;

import com.demo.hotel.provider.domain.TrainingEc;
import com.demo.hotel.provider.mapper.TrainingEcMapper;
import com.demo.hotel.provider.api.TrainingEcService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

/**
 * @author syj
 */
@Service(version = "1.0.0")
public class TrainingEcServiceImpl implements TrainingEcService{

    @Resource
    private TrainingEcMapper trainingEcMapper;

    @Override
    public List<TrainingEc> selectAll() {
        return trainingEcMapper.selectAll();
    }
}

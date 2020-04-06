package com.demo.hotel.provider.service;

import javax.annotation.Resource;

import com.demo.hotel.provider.domain.TrainingContent;
import com.demo.hotel.provider.mapper.TrainingContentMapper;
import com.demo.hotel.provider.api.TrainingContentService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author syj
 */
@Service(version = "1.0.0")
public class TrainingContentServiceImpl implements TrainingContentService{

    @Resource
    private TrainingContentMapper trainingContentMapper;

    @Override
    public int insert(TrainingContent trainingContent) {
        return trainingContentMapper.insert(trainingContent);
    }

    @Override
    public int update(TrainingContent trainingContent) {
        return trainingContentMapper.updateByPrimaryKey(trainingContent);
    }

    @Override
    public int delete(Long id) {
        return trainingContentMapper.deleteByPrimaryKey(id);
    }
}

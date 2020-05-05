package com.demo.hotel.provider.service;

import com.demo.hotel.provider.domain.Inspection;

import javax.annotation.Resource;
import com.demo.hotel.provider.mapper.InspectionMapper;
import com.demo.hotel.provider.api.InspectionService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

/**
 * @author syj
 */
@Service(version = "1.0.0")
public class InspectionServiceImpl implements InspectionService{

    @Resource
    private InspectionMapper inspectionMapper;

    @Override
    public int insert(Inspection domain) {
        return inspectionMapper.insert(domain);
    }

    @Override
    public int update(Inspection domain) {
        return inspectionMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int delete(Long id) {
        return inspectionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Inspection> selectAll() {
        return inspectionMapper.selectAll();
    }
}

package com.demo.hotel.provider.service;

import javax.annotation.Resource;

import com.demo.hotel.provider.domain.FacilityApply;
import com.demo.hotel.provider.mapper.FacilityApplyMapper;
import com.demo.hotel.provider.api.FacilityApplyService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author syj
 */
@Service(version = "1.0.0")
public class FacilityApplyServiceImpl implements FacilityApplyService{

    @Resource
    private FacilityApplyMapper facilityApplyMapper;

    @Override
    public int insert(FacilityApply domain) {
        return facilityApplyMapper.insert(domain);
    }

    @Override
    public int update(FacilityApply domain) {
        return facilityApplyMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int delete(Long id) {
        return facilityApplyMapper.deleteByPrimaryKey(id);
    }
}

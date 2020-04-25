package com.demo.hotel.provider.service;

import javax.annotation.Resource;

import com.demo.hotel.provider.domain.FacilityApplyE;
import com.demo.hotel.provider.mapper.FacilityApplyEMapper;
import com.demo.hotel.provider.api.FacilityApplyEService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

/**
 * @author syj
 */
@Service(version = "1.0.0")
public class FacilityApplyEServiceImpl implements FacilityApplyEService{

    @Resource
    private FacilityApplyEMapper facilityApplyEMapper;

    @Override
    public List<FacilityApplyE> selectAll() {
        return facilityApplyEMapper.selectAll();
    }
}

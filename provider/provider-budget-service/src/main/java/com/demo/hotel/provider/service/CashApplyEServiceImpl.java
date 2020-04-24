package com.demo.hotel.provider.service;

import com.demo.hotel.provider.domain.CashApplyE;

import javax.annotation.Resource;
import com.demo.hotel.provider.mapper.CashApplyEMapper;
import com.demo.hotel.provider.api.CashApplyEService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

/**
 * @author syj
 */
@Service(version = "1.0.0")
public class CashApplyEServiceImpl implements CashApplyEService{

    @Resource
    private CashApplyEMapper cashApplyEMapper;

    @Override
    public List<CashApplyE> selectAll() {
        return cashApplyEMapper.selectAll();
    }
}

package com.demo.hotel.provider.service;

import com.demo.hotel.provider.domain.CashApply;

import javax.annotation.Resource;
import com.demo.hotel.provider.mapper.CashApplyMapper;
import com.demo.hotel.provider.api.CashApplyService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author syj
 */
@Service(version = "1.0.0")
public class CashApplyServiceImpl implements CashApplyService{

    @Resource
    private CashApplyMapper cashApplyMapper;

    @Override
    public int insert(CashApply domain) {
        return cashApplyMapper.insert(domain);
    }

    @Override
    public int update(CashApply domain) {
        return cashApplyMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int delete(Long id) {
        return cashApplyMapper.deleteByPrimaryKey(id);
    }
}

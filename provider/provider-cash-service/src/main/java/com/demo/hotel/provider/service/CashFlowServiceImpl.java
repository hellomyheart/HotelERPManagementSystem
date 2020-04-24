package com.demo.hotel.provider.service;

import com.demo.hotel.provider.domain.CashFlow;

import javax.annotation.Resource;
import com.demo.hotel.provider.mapper.CashFlowMapper;
import com.demo.hotel.provider.api.CashFlowService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

/**
 * @author syj
 */
@Service(version = "1.0.0")
public class CashFlowServiceImpl implements CashFlowService{

    @Resource
    private CashFlowMapper cashFlowMapper;

    @Override
    public int insert(CashFlow domain) {
        return cashFlowMapper.insert(domain);
    }

    /**
     * 不允许update
     * @param domain
     * @return
     */
    @Override
    public int update(CashFlow domain) {
        return 0;
    }

    @Override
    public int delete(Long id) {
        return cashFlowMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<CashFlow> selectAll() {
        return cashFlowMapper.selectAll();
    }
}

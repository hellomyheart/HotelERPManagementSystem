package com.demo.hotel.provider.service;

import com.demo.hotel.provider.domain.Repairs;

import javax.annotation.Resource;
import com.demo.hotel.provider.mapper.RepairsMapper;
import com.demo.hotel.provider.api.RepairsService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

/**
 * @author syj
 */
@Service(version = "1.0.0")
public class RepairsServiceImpl implements RepairsService{

    @Resource
    private RepairsMapper repairsMapper;

    @Override
    public int insert(Repairs domain) {
        return repairsMapper.insert(domain);
    }

    @Override
    public int update(Repairs domain) {
        return repairsMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int delete(Long id) {
        return repairsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Repairs> selectAll() {
        return repairsMapper.selectAll();
    }
}

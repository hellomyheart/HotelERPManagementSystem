package com.demo.hotel.provider.service;

import com.demo.hotel.provider.domain.Cleaning;

import javax.annotation.Resource;
import com.demo.hotel.provider.mapper.CleaningMapper;
import com.demo.hotel.provider.api.CleaningService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

/**
 * @author syj
 */
@Service(version = "1.0.0")
public class CleaningServiceImpl implements CleaningService{

    @Resource
    private CleaningMapper cleaningMapper;

    //只允许查询和更新
    @Override
    public int insert(Cleaning domain) {
        return 0;
    }

    @Override
    public int update(Cleaning domain) {
        Cleaning cleaning=new Cleaning();
        cleaning.setId(domain.getId());
        cleaning.setCleaningNumber(domain.getCleaningNumber());
        return cleaningMapper.updateByPrimaryKeySelective(cleaning);
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public List<Cleaning> selectAll() {
        return cleaningMapper.selectAll();
    }
}

package com.demo.hotel.provider.api;

import com.demo.hotel.provider.domain.Position;
import com.demo.hotel.provider.domain.PositionD;

import java.util.List;

/**
 * @author syj
 */
public interface PositionDService{

    /**
     * 查询所有
     * @return
     */
    List<PositionD> selectAll();


}

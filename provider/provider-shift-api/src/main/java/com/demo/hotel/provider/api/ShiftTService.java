package com.demo.hotel.provider.api;

import com.demo.hotel.provider.domain.ShiftT;

import java.util.List;

/**
 * @author syj
 */
public interface ShiftTService{


    /**
     * 查询所有
     *
     * @return
     */
    List<ShiftT> selectAll();

}

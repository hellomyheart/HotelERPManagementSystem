package com.demo.hotel.provider.api;

import com.demo.hotel.provider.domain.ShiftTypeD;

import java.util.List;

/**
 * 排班分类查询api
 *
 * @author syj
 */
public interface ShiftTypeDService {

    /**
     * 查询所有
     *
     * @return
     */
    List<ShiftTypeD> selectAll();


}

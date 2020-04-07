package com.demo.hotel.provider.api;

import com.demo.hotel.provider.domain.ShiftEmployeeE;

import java.util.List;

/**
 * 查询排班API
 *
 * @author syj
 */
public interface ShiftEmployeeEService {

    /**
     * 查询所有
     *
     * @return
     */
    List<ShiftEmployeeE> selectAll();
}

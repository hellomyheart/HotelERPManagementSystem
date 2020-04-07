package com.demo.hotel.provider.api;

import com.demo.hotel.provider.domain.Shift;

/**
 * 排班班次api
 * @author syj
 */
public interface ShiftService{

    /**
     * 新增
     * @param shift
     * @return
     */
    int insert(Shift shift);

    /**
     * 修改
     * @param shift
     * @return
     */
    int update(Shift shift);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int delete(Long id);


}

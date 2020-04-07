package com.demo.hotel.provider.api;

import com.demo.hotel.provider.domain.ShiftEmployee;

/**
 * 排班表api
 *
 * @author syj
 */
public interface ShiftEmployeeService {

    /**
     * 新增
     *
     * @param shiftEmployee
     * @return
     */
    int insert(ShiftEmployee shiftEmployee);

    /**
     * 修改
     *
     * @param shiftEmployee
     * @return
     */
    int update(ShiftEmployee shiftEmployee);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int delete(Long id);
}

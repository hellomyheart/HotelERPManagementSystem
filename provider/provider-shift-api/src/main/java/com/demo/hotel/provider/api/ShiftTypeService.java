package com.demo.hotel.provider.api;


import com.demo.hotel.provider.domain.ShiftType;

/**
 * 排班分类api
 *
 * @author syj
 */
public interface ShiftTypeService {

    /**
     * 新增
     *
     * @param shiftType
     * @return
     */
    int insert(ShiftType shiftType);

    /**
     * 修改
     *
     * @param shiftType
     * @return
     */
    int update(ShiftType shiftType);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int delete(Long id);


}

package com.demo.hotel.provider.api;

import com.demo.hotel.provider.domain.Position;

/**
 * @author syj
 */
public interface PositionService {

    /**
     * 新增
     * @param position
     * @return
     */
    int insert(Position position);

    /**
     * 修改
     * @param position
     * @return
     */
    int update(Position position);

    /**
     * 删除
     * @param id
     * @return
     */
    int delete(Long id);
}


package com.demo.hotel.provider.api;

import com.demo.hotel.provider.domain.RoomType;

/**
 * @author syj
 */
public interface RoomTypeService extends BaseSingleTableApi<RoomType>{

    /**
     * 通过ID查询房间类型
     * @param id
     * @return
     */
    RoomType getById(Long id);
}

package com.demo.hotel.provider.api;

import com.demo.hotel.provider.domain.Room;

import java.util.List;

/**
 * @author syj
 */
public interface RoomService extends BaseTableApi<Room>{

    /**
     * 查询所有房间
     *
     * @return
     */
    List<Room> selectAllRoom();

    /**
     * 通过ID查询房间
     * @param id
     * @return
     */
    Room getById(Long id);
}

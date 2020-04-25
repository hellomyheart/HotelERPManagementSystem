package com.demo.hotel.provider.api;

import com.demo.hotel.provider.doamin.ViewDomain;

import java.util.List;

/**
 * @program: HotelERPManagementSystem
 * @description: 基础的视图api
 * @author: syj
 * @create: 2020-04-23 08:14
 **/
public interface BaseViewApi<T> {

    /**
     * 查询所有
     *
     * @return
     */
    List<T> selectAll();
}

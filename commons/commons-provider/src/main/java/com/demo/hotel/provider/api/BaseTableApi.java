package com.demo.hotel.provider.api;

/**
 * @program: HotelERPManagementSystem
 * @description: 基础的表Api
 * @author: syj
 * @create: 2020-04-23 08:10
 **/
public interface BaseTableApi<T>{

    /**
     * 新增
     *
     * @param domain
     * @return
     */
    int insert(T domain);

    /**
     * 修改
     *
     * @param domain
     * @return
     */
    int update(T domain);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int delete(Long id);
}

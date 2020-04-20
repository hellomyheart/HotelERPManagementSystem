package com.demo.hotel.provider.api;

/**
 * @program: HotelERPManagementSystem
 * @description:
 * @author: syj
 * @create: 2020-04-19 17:02
 **/
public interface RedisService {

    /**
     * 存储
     *
     * @param content
     * @param key
     * @return
     */
    void insert(String key, String content);

    /**
     * 读取
     *
     * @param key
     * @return
     */
    String get(String key);
}

package com.demo.hotel.business.dto.params;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: HotelERPManagementSystem
 * @description: 修改头像参数
 * @author: syj
 * @create: 2020-03-30 14:19
 **/
@Data
public class IconParam implements Serializable {

    /**
     * 用户名
     */
    private String username;

    /**
     * 头像地址
     */
    private String path;

}

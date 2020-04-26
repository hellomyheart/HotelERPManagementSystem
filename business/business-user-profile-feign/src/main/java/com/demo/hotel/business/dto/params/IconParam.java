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


    private static final long serialVersionUID = 7909979192940433184L;
    /**
     * 用户id
     */
    private Long id;

    /**
     * 头像地址
     */
    private String path;

}

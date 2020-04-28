package com.demo.hotel.business.dto;

import com.demo.hotel.provider.domain.Users;
import lombok.Data;

/**
 * @program: HotelERPManagementSystem
 * @description:
 * @author: syj
 * @create: 2020-04-28 23:19
 **/
@Data
public class UserRegDTO extends Users {
    /**
     * 验证码
     */
    private String code;
}

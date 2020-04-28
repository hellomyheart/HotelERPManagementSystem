package com.demo.hotel.cloud.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: HotelERPManagementSystem
 * @description:
 * @author: syj
 * @create: 2020-04-20 07:30
 **/
@Data
public class UserCodeDTO implements Serializable {

    private static final long serialVersionUID = -9024663422366240684L;
    private String phone;
    private String code;
}

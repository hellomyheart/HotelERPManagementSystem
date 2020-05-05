package com.demo.hotel.business.dto.param;

import lombok.Data;

import java.util.Date;

/**
 * @program: HotelERPManagementSystem
 * @description: DeploymentParam
 * @author: syj
 * @create: 2020-04-03 15:10
 **/
@Data
public class RepairsParam implements BaseParam {


    private static final long serialVersionUID = 3121783243003040197L;
    /**
     * 客房ID
     */
    private Long roomId;


    /**
     * 状态，0等待维修，1维修完成
     */
    private Integer status;

    /**
     * 备注
     */
    private String note;
}

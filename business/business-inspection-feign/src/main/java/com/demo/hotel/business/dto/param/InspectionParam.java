package com.demo.hotel.business.dto.param;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: HotelERPManagementSystem
 * @description: DeploymentParam
 * @author: syj
 * @create: 2020-04-03 15:10
 **/
@Data
public class InspectionParam implements BaseParam {


    private static final long serialVersionUID = -2879114899620909586L;
    /**
     * 客房ID
     */
    private Long roomId;


    /**
     * 备注
     */
    private String note;
}

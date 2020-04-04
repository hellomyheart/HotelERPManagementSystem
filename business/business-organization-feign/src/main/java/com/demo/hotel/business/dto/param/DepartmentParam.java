package com.demo.hotel.business.dto.param;

import lombok.Data;

/**
 * @program: HotelERPManagementSystem
 * @description: DeploymentParam
 * @author: syj
 * @create: 2020-04-03 15:10
 **/
@Data
public class DepartmentParam {

    /**
     * 部门名
     */
    private String name;

    /**
     * 部门介绍
     */
    private String note;
}

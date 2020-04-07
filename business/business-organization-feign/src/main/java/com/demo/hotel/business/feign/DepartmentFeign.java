package com.demo.hotel.business.feign;

import com.demo.hotel.business.dto.DepartmentDTO;
import com.demo.hotel.business.dto.param.DepartmentParam;
import com.demo.hotel.business.feign.fallback.DepartmentFeignFallback;
import com.demo.hotel.configuration.FeignRequestConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @program: HotelERPManagementSystem
 * @description: 部门Feign
 * @author: syj
 * @create: 2020-04-03 16:04
 **/

//value指向服务名，application
//path对应controller中的ResquestMapping
//feign类似于http客户端
//configuration = FeignRequestConfiguration.class是为了配置拦截器在请求头中加token
@FeignClient(value = "business-organization", path = "organization/department", configuration = FeignRequestConfiguration.class, fallback = DepartmentFeignFallback.class)
public interface DepartmentFeign {

    /**
     * 获取部门信息
     *
     * @return
     */
    @GetMapping(value = "info")
    String info();

    /**
     * 新增部门
     * @param departmentParam
     * @return
     */
    @PostMapping(value = "add")
    String add(@RequestBody DepartmentParam departmentParam);


    /**
     * 修改部门信息
     * @param departmentDTO
     * @return
     */
    @PostMapping(value = "update")
    String update(@RequestBody DepartmentDTO departmentDTO);

    /**
     * 删除部门
     *
     * @param id
     * @return
     */
    @PostMapping(value = "delete")
    String delete(@RequestBody Long id);

}

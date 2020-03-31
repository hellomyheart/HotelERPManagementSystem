package com.demo.hotel.business.controller;

import com.demo.hotel.business.dto.AdminDTO;
import com.demo.hotel.business.dto.params.ProfileParam;
import com.demo.hotel.commons.dto.ResponseResult;
import com.demo.hotel.provider.api.AdminService;
import com.demo.hotel.provider.domain.Admin;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: HotelERPManagementSystem
 * @description: admin个人信息管理
 * @author: syj
 * @create: 2020-03-30 13:56
 **/
@RestController
@RequestMapping(value = "profile")
public class ProfileController {

    @Reference(version = "1.0.0")
    private AdminService adminService;

    @Resource
    private BCryptPasswordEncoder passwordEncoder;




    /**
     * 获取个人信息
     *
     * @param username {@code String} 用户名
     * @return {@link ResponseResult}
     */
    @GetMapping(value = "info/{username}")
    public ResponseResult<AdminDTO> info(@PathVariable String username){
        Admin admin=adminService.get(username);
        AdminDTO dto = new AdminDTO();
        BeanUtils.copyProperties(admin,dto);
        return new ResponseResult<AdminDTO>(ResponseResult.CodeStatus.OK,"获取个人信息",dto);
    }

    /**
     * 更新个人信息
     *
     * @param profileParam {@link ProfileParam}
     * @return {@link ResponseResult}
     */
    @PostMapping(value = "update")
    public ResponseResult<Void> update(@RequestBody ProfileParam profileParam) {
//TODO 更新职工号没写
        Admin newAdmin = new Admin();
        BeanUtils.copyProperties(profileParam, newAdmin);
        int result = adminService.update(newAdmin);

        // 成功
        if (result > 0) {
            return new ResponseResult<Void>(ResponseResult.CodeStatus.OK, "更新个人信息成功");
        }

        // 失败
        else {
            return new ResponseResult<Void>(ResponseResult.CodeStatus.FAIL, "更新个人信息失败");
        }
    }

}

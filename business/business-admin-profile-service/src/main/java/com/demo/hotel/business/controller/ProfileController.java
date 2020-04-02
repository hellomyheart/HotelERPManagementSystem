package com.demo.hotel.business.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.demo.hotel.business.controller.fallback.ProfileControllerFallback;
import com.demo.hotel.business.dto.AdminDTO;
import com.demo.hotel.business.dto.params.IconParam;
import com.demo.hotel.business.dto.params.PasswordParam;
import com.demo.hotel.business.dto.params.ProfileParam;
import com.demo.hotel.commons.dto.CodeStatus;
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
    @SentinelResource(value = "info", fallback = "infoFallback", fallbackClass = ProfileControllerFallback.class)
    public ResponseResult<AdminDTO> info(@PathVariable String username) {
        Admin admin = adminService.get(username);
        AdminDTO dto = new AdminDTO();
        BeanUtils.copyProperties(admin, dto);
        return new ResponseResult<AdminDTO>(CodeStatus.OK, "获取个人信息", dto);
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
            return new ResponseResult<Void>(CodeStatus.OK, "更新个人信息成功");
        }

        // 失败
        else {
            return new ResponseResult<Void>(CodeStatus.FAIL, "更新个人信息失败");
        }


    }

    /**
     * 修改密码
     *
     * @param passwordParam {@link PasswordParam}
     * @return {@link ResponseResult}
     */
    @PostMapping(value = "modify/password")
    public ResponseResult<Void> modifyPassword(@RequestBody PasswordParam passwordParam) {
        Admin admin = adminService.get(passwordParam.getUsername());

        // 旧密码正确
        if (passwordEncoder.matches(passwordParam.getOldPassword(), admin.getPassword())) {
            int result = adminService.modifyPassword(admin.getUsername(), passwordParam.getNewPassword());
            if (result > 0) {
                return new ResponseResult<Void>(CodeStatus.OK, "修改密码成功");
            }
        }

        // 旧密码错误
        else {
            return new ResponseResult<Void>(CodeStatus.FAIL, "旧密码不匹配，请重试");
        }

        return new ResponseResult<Void>(CodeStatus.FAIL, "修改密码失败");
    }

    /**
     * 修改头像
     *
     * @param iconParam {@link IconParam}
     * @return {@link ResponseResult}
     */
    @PostMapping(value = "modify/icon")
    public ResponseResult<Void> modifyIcon(@RequestBody IconParam iconParam) {
        int result = adminService.modifyIcon(iconParam.getUsername(), iconParam.getPath());

        // 成功
        if (result > 0) {
            return new ResponseResult<Void>(CodeStatus.OK, "更新头像成功");
        }

        // 失败
        else {
            return new ResponseResult<Void>(CodeStatus.FAIL, "更新头像失败");
        }
    }
}

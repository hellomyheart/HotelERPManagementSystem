package com.demo.hotel.business.controller;

import com.demo.hotel.commons.dto.ResponseResult;
import com.demo.hotel.provider.api.AdminService;
import com.demo.hotel.provider.domain.Admin;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户注册
 * @author syj
 */

@RestController
@RequestMapping(value = "admin/reg")
public class AdminRegController {

    @Reference(version = "1.0.0")
    private AdminService adminService;

    /**
     * 用户注册
     * @param admin {@link Admin}
     * @return {@link ResponseResult}
     */
    @PostMapping(value = "")
    public ResponseResult<Admin> reg(@RequestBody Admin admin){
        String message = validateReg(admin);
        //邮箱唯一
        if (message==null){
            int result = adminService.insert(admin);
            //注册成功
            if (result>0){
                Admin newAdmin = adminService.get(admin.getEmail());
                return new ResponseResult<Admin>(ResponseResult.CodeStatus.OK,"用户注册成功",newAdmin);
            }
            //注册失败
            else{
                return new ResponseResult<Admin>(ResponseResult.CodeStatus.FAIL,"用户注册失败，请检查网络后重试");
            }
        }
        //邮箱已存在
        else {
            return new ResponseResult<Admin>(ResponseResult.CodeStatus.FAIL,message);
        }
    }

    /**
     * 昵称验证
     * @param admin {@link Admin}
     * @return 验证结果
     */
    private String validateReg(Admin admin){
        Admin admin1=adminService.get(admin.getEmail());
        if (admin1 != null){
            return "此邮箱已存在，请登录";
        }
        return null;
    }
}

package com.demo.hotel.business.controller;
import java.util.Date;

import com.demo.hotel.business.dto.UserRegDTO;
import com.demo.hotel.cloud.api.MessageService;
import com.demo.hotel.cloud.dto.UserCodeDTO;
import com.demo.hotel.commons.dto.CodeStatus;
import com.demo.hotel.commons.dto.ResponseResult;
import com.demo.hotel.provider.api.RedisService;
import com.demo.hotel.provider.api.UsersService;
import com.demo.hotel.provider.domain.Users;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户注册
 *
 * @author syj
 */

@RestController
@RequestMapping(value = "reg")
public class UserRegController {

    @Reference(version = "1.0.0")
    UsersService usersService;

    @Reference(version = "1.0.0")
    RedisService redisService;

    @Reference(version = "1.0.0")
    MessageService messageService;

    String code="Code:";

    /**
     * 发送验证码
     *
     * @return
     */
    @PostMapping(value = "send")
    public ResponseResult<Users> send(@RequestBody UserCodeDTO userCodeDTO) {
        String number = userCodeDTO.getPhone();
        String message = validateReg(number);
        //用户验证
        if (message == null) {
            //随机验证码
            String code_v = String.valueOf((int) (Math.random() * (89999) + 10000));

            //存入redis
            redisService.insert(code + number, code_v);
            userCodeDTO.setCode(code_v);
            //发送验证码
            boolean result = messageService.sendUserCode(userCodeDTO);


            //发送成功
            if (result) {
                return new ResponseResult<>(CodeStatus.OK, "验证码发送成功");
            }
            //发送失败
            else {
                return new ResponseResult<>(CodeStatus.FAIL, "验证码发送失败，请检查网络后重试");
            }
        }
        //手机号已存在
        else {
            return new ResponseResult<Users>(CodeStatus.FAIL, message);
        }
    }

    @PostMapping(value = "user")
    public ResponseResult<Users> reg(@RequestBody UserRegDTO user) {

        //验证验证码
        if (user.getCode().equals(redisService.get(code+user.getPhone()))) {

            Users users=new Users();


            BeanUtils.copyProperties(user,users);
            int insert = usersService.insert(users);
            if (insert>0){
                return new ResponseResult<>(CodeStatus.OK, "注册成功，请登录");
            }
            else {
                return new ResponseResult<>(CodeStatus.FAIL, "注册失败，请检查网络");
            }

        }else{
            return new ResponseResult<>(CodeStatus.FAIL, "验证码错误，请重试");
        }
}
    /**
     * 手机号验证
     *
     * @return
     */
    private String validateReg(String phone) {
        if (phone.length() != 11) {
            return "手机号输入错误！";
        }
        Users users1 = usersService.get(phone);
        if (users1 != null) {
            return "此手机号已注册，请直接登录";
        }
        return null;
    }
}

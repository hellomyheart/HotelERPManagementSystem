package com.demo.hotel.business.controller;

import com.demo.hotel.business.dto.LoginParam;
import com.demo.hotel.commons.dto.ResponseResult;
import com.google.common.collect.Maps;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
* @Description: 登录管理
* @Author: syj
* @Date: 2020/3/28
*/
@CrossOrigin(origins = "*" ,maxAge = 3600)
@RestController
public class LoginController {
    //这里是封装登录api供前端调用
    /**
    * @Description: 登录
    * @Param: [loginParam] {@link LoginParam}
    * @return: com.demo.hotel.commons.dto.ResponseResult
    * @Author: syj
    * @Date: 2020/3/28
    */
    @PostMapping("/user/login")
    public ResponseResult<Map<String ,Object>> login(@RequestBody LoginParam loginParam){
        Map<String,Object> result = Maps.newHashMap();
        result.put("token", "123456");
        //状态码，消息，数据对象
        return new ResponseResult<Map<String ,Object>>(ResponseResult.CodeStatus.OK,"登录成功",result);
    };
}

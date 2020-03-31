package com.demo.hotel.business.feign.fallback;

import com.demo.hotel.business.dto.params.IconParam;
import com.demo.hotel.business.dto.params.PasswordParam;
import com.demo.hotel.business.dto.params.ProfileParam;
import com.demo.hotel.business.feign.ProfileFeign;
import com.demo.hotel.commons.dto.ResponseResult;
import com.demo.hotel.commons.utils.MapperUtils;
import org.springframework.stereotype.Component;

/**
 * @program: HotelERPManagementSystem
 * @description: admin-profile服务熔断器
 * @author: syj
 * @create: 2020-03-31 17:08
 **/
@Component
public class ProfileFeignFallback implements ProfileFeign {
    public static final String BREAKING_MESSAGE = "请求失败了，请检查您的网络";
    @Override
    public String info(String username) {
        try {
            return MapperUtils.obj2json(new ResponseResult<Void>(ResponseResult.CodeStatus.BREAKING, BREAKING_MESSAGE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String update(ProfileParam profileParam) {
        try {
            return MapperUtils.obj2json(new ResponseResult<Void>(ResponseResult.CodeStatus.BREAKING, BREAKING_MESSAGE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String modifyPassword(PasswordParam passwordParam) {
        try {
            return MapperUtils.obj2json(new ResponseResult<Void>(ResponseResult.CodeStatus.BREAKING, BREAKING_MESSAGE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String modifyIcon(IconParam iconParam) {
        try {
            return MapperUtils.obj2json(new ResponseResult<Void>(ResponseResult.CodeStatus.BREAKING, BREAKING_MESSAGE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

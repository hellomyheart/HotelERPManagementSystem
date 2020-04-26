package com.demo.hotel.business.feign.fallback;

import com.demo.hotel.business.dto.UserDTO;
import com.demo.hotel.business.dto.params.IconParam;
import com.demo.hotel.business.dto.params.PasswordParam;
import com.demo.hotel.business.dto.params.UserParam;
import com.demo.hotel.business.feign.UserFeign;
import org.springframework.stereotype.Component;

/**
 * @program: HotelERPManagementSystem
 * @description: admin-profile服务熔断器
 * @author: syj
 * @create: 2020-03-31 17:08
 **/
@Component
public class UserFeignFallback implements UserFeign {

    CommonsFeignFallback<UserDTO> cf=new CommonsFeignFallback<>();

    @Override
    public String info() {
     return cf.message();
    }

    @Override
    public String update(UserParam profileParam) {
        return cf.message();
    }

    @Override
    public String modifyPassword(PasswordParam passwordParam) {
        return cf.message();
    }

    @Override
    public String modifyIcon(IconParam iconParam) {
        return cf.message();
    }
}

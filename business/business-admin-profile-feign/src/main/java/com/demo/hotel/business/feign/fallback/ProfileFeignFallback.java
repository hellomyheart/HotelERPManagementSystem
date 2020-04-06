package com.demo.hotel.business.feign.fallback;

import com.demo.hotel.business.dto.AdminDTO;
import com.demo.hotel.business.dto.params.IconParam;
import com.demo.hotel.business.dto.params.PasswordParam;
import com.demo.hotel.business.dto.params.ProfileParam;
import com.demo.hotel.business.feign.ProfileFeign;
import com.demo.hotel.commons.dto.CodeStatus;
import org.springframework.stereotype.Component;

/**
 * @program: HotelERPManagementSystem
 * @description: admin-profile服务熔断器
 * @author: syj
 * @create: 2020-03-31 17:08
 **/
@Component
public class ProfileFeignFallback implements ProfileFeign {

    CommonsFeignFallback<AdminDTO> commonsFeignFallback=new CommonsFeignFallback<>();

    @Override
    public String info(String username) {
     return commonsFeignFallback.message(CodeStatus.BREAKING, FeignFallbackMessage.BREAKING_MESSAGE);
    }

    @Override
    public String update(ProfileParam profileParam) {
        return commonsFeignFallback.message(CodeStatus.BREAKING, FeignFallbackMessage.BREAKING_MESSAGE);
    }

    @Override
    public String modifyPassword(PasswordParam passwordParam) {
        return commonsFeignFallback.message(CodeStatus.BREAKING, FeignFallbackMessage.BREAKING_MESSAGE);
    }

    @Override
    public String modifyIcon(IconParam iconParam) {
        return commonsFeignFallback.message(CodeStatus.BREAKING, FeignFallbackMessage.BREAKING_MESSAGE);
    }
}

package com.demo.hotel.business.controller.fallback;

import com.demo.hotel.business.dto.AdminDTO;
import com.demo.hotel.commons.dto.CodeStatus;
import com.demo.hotel.commons.dto.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: HotelERPManagementSystem
 * @description: admin管理服务熔断器
 * @author: syj
 * @create: 2020-03-31 20:22
 **/
public class ProfileControllerFallback {
    private static final Logger logger = LoggerFactory.getLogger(ProfileControllerFallback.class);

    /**
     * 熔断方法
     *
     * @param username {@code String} 用户名
     * @return {@link ResponseResult<AdminDTO>}
     */
    public static ResponseResult<AdminDTO> infoFallback(String username, Throwable ex) {
        logger.warn("Invoke infoFallback: " + ex.getClass().getTypeName());
        ex.printStackTrace();
        return new CommonsFallback<AdminDTO>().returnResponseResult(CodeStatus.BREAKING, FallbackMessage.BREAKING_MESSAGE, null);
    }

}
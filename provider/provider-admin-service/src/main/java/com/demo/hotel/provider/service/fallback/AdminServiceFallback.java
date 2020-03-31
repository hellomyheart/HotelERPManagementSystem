package com.demo.hotel.provider.service.fallback;

import com.demo.hotel.provider.domain.Admin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: HotelERPManagementSystem
 * @description: admin服务提供者熔断器
 * @author: syj
 * @create: 2020-03-31 19:38
 **/
public class AdminServiceFallback {
    private static final Logger logger = LoggerFactory.getLogger(AdminServiceFallback.class);

    /**
     * 熔断方法
     *
     * @param username {@code String} 用户名
     * @param ex       {@code Throwable} 异常信息
     * @return {@link Admin} 熔断后的固定结果
     */
    public static Admin getByUsernameFallback(String username, Throwable ex) {
        logger.warn("Invoke getByUsernameFallback: " + ex.getClass().getTypeName());
        ex.printStackTrace();
        return null;
    }

}
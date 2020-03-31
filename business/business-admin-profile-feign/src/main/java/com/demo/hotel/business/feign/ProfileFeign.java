package com.demo.hotel.business.feign;

import com.demo.hotel.business.dto.params.IconParam;
import com.demo.hotel.business.dto.params.PasswordParam;
import com.demo.hotel.business.dto.params.ProfileParam;
import com.demo.hotel.configuration.FeignRequestConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @program: HotelERPManagementSystem
 * @description: Profile接口
 * @author: syj
 * @create: 2020-03-30 14:12
 **/

//value指向服务名，application
//path对应controller中的ResquestMapping
//feign类似于http客户端
//configuration = FeignRequestConfiguration.class是为了配置拦截器在请求头中加token
@FeignClient(value = "business-admin-profile", path = "profile", configuration = FeignRequestConfiguration.class)
public interface ProfileFeign {

    /**
     * 获取个人信息
     *
     * @param username {@code String} 用户名
     * @return {@code String} JSON
     */
    @GetMapping(value = "info/{username}")
    String info(@PathVariable String username);

    /**
     * 更新个人信息
     *
     * @param profileParam {@link ProfileParam}
     * @return {@code String} JSON
     */
    @PostMapping(value = "update")
    String update(@RequestBody ProfileParam profileParam);

    /**
     * 修改密码
     *
     * @param passwordParam {@link PasswordParam}
     * @return {@code String} JSON
     */
    @PostMapping(value = "modify/password")
    String modifyPassword(@RequestBody PasswordParam passwordParam);

    /**
     * 修改头像
     *
     * @param iconParam {@link IconParam}
     * @return {@code String} JSON
     */
    @PostMapping(value = "modify/icon")
    String modifyIcon(@RequestBody IconParam iconParam);
}

package com.demo.hotel.business.controller;

import com.demo.hotel.business.BusinessException;
import com.demo.hotel.business.BusinessStatus;
import com.demo.hotel.business.dto.LoginInfo;
import com.demo.hotel.business.dto.LoginParam;
import com.demo.hotel.business.feign.ProfileFeign;
import com.demo.hotel.cloud.api.MessageService;
import com.demo.hotel.cloud.dto.AdminLoginLogDTO;
import com.demo.hotel.cloud.dto.UserCodeDTO;
import com.demo.hotel.commons.dto.CodeStatus;
import com.demo.hotel.commons.dto.ResponseResult;
import com.demo.hotel.commons.utils.MapperUtils;
import com.demo.hotel.commons.utils.OkHttpClientUtil;
import com.demo.hotel.commons.utils.UserAgentUtils;
import com.demo.hotel.provider.api.AdminService;
import com.demo.hotel.provider.domain.Admin;
import com.google.common.collect.Maps;
import eu.bitwalker.useragentutils.Browser;
import okhttp3.Response;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

/**
 * 登录管理
 *
 * @author syj
 */
@RestController
public class LoginController {

    private static final String URL_OAUTH_TOKEN = "http://localhost:9001/oauth/token";

    @Value("${business.oauth2.grant_type}")
    public String oauth2_grant_type;

    @Value("${business.oauth2.client_id}")
    public String oauth2_client_id;

    @Value("${business.oauth2.client_secret}")
    public String oauth2_client_secret;

    @Resource(name = "userDetailsService")
    public UserDetailsService userDetailsService;

    @Resource
    public BCryptPasswordEncoder passwordEncoder;

    @Resource
    public TokenStore tokenStore;

    @Resource
    private ProfileFeign profileFeign;

    @Reference(version = "1.0.0")
    private AdminService adminService;

    @Reference(version = "1.0.0")
    private MessageService messageService;


    /**
     * 登录
     *
     * @param loginParam 登录参数
     * @return {@link ResponseResult}
     */
    @PostMapping(value = "/user/login")
    public ResponseResult<Map<String, Object>> login(@RequestBody LoginParam loginParam, HttpServletRequest request) throws Exception {
        // 封装返回的结果集
        Map<String, Object> result = Maps.newHashMap();



        //验证账号密码
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginParam.getUsername());

        if (userDetails == null || !passwordEncoder.matches(loginParam.getPassword(), userDetails.getPassword())) {
            throw new BusinessException(BusinessStatus.ADMIN_PASSWORD);
        }

        // 通过 HTTP 客户端请求登录接口

        Map<String, String> params = Maps.newHashMap();
        params.put("username", loginParam.getUsername());
        params.put("password", loginParam.getPassword());
        params.put("grant_type", oauth2_grant_type);
        params.put("client_id", oauth2_client_id);
        params.put("client_secret", oauth2_client_secret);

        try (Response response = OkHttpClientUtil.getInstance().postData(URL_OAUTH_TOKEN, params)) {
            //防止空指针异常
            String jsonString = Objects.requireNonNull(response.body()).string();
            Map<String, Object> jsonMap = MapperUtils.json2map(jsonString);
            String token = String.valueOf(jsonMap.get("access_token"));
            result.put("token", token);
            // 发送登录日志
            sendAdminLoginLog(userDetails.getUsername(), request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(result);
        return new ResponseResult<Map<String, Object>>(CodeStatus.OK, "登录成功！", result);
    }

    /**
     * @Description: 获取用户信息api
     * @Param: []
     * @return: com.demo.hotel.commons.dto.ResponseResult<com.demo.hotel.business.dto.LoginInfo>
     * @Author: syj
     * @Date: 2020/3/29
     */
    //以下注解设置访问权限
    @PreAuthorize("hasAuthority('USER')")
    @GetMapping(value = "/user/info")
    public ResponseResult<LoginInfo> info() throws Exception {
        //获取认证信息上下文的信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // 获取个人信息,使用feign
        String jsonString = profileFeign.info();
        Admin admin = MapperUtils.json2pojoByTree(jsonString, "data", Admin.class);
        //熔断
        if (admin == null) {
            return MapperUtils.json2pojo(jsonString, ResponseResult.class);
        }
        // 封装并返回结果
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setName(admin.getUsername());
        loginInfo.setAvatar(admin.getIcon());
        loginInfo.setNickname(admin.getNickname());
        loginInfo.setRoles( authentication.getAuthorities().toArray());
        return new ResponseResult<LoginInfo>(CodeStatus.OK, "获取用户信息", loginInfo);
    }

    /**
     * @Description: 注销
     * @Param: [request]
     * @return: com.demo.hotel.commons.dto.ResponseResult<java.lang.Void>
     * @Author: syj
     * @Date: 2020/3/29
     */
    @PreAuthorize("hasAuthority('USER')")
    @PostMapping(value = "/user/logout")
    public ResponseResult<Void> logout(HttpServletRequest request) {
        String token = request.getParameter("access_token");
        //删除token
        OAuth2AccessToken oAuth2AccessToken = tokenStore.readAccessToken(token);
        tokenStore.removeAccessToken(oAuth2AccessToken);

        return new ResponseResult<Void>(CodeStatus.OK, "用户注销", null);
    }

    /**
     * 发送登录日志
     *
     * @param request {@link HttpServletRequest}
     */
    private void sendAdminLoginLog(String username, HttpServletRequest request) {
        Admin admin = adminService.get(username);

        if (admin != null) {
            // 获取请求的用户代理信息
            Browser browser = UserAgentUtils.getBrowser(request);
            String ip = UserAgentUtils.getIpAddr(request);
            String address = UserAgentUtils.getIpInfo(ip).getCity();

            AdminLoginLogDTO dto = new AdminLoginLogDTO();
            dto.setAdminId(admin.getId());
            dto.setCreateTime(new Date());
            dto.setIp(ip);
            dto.setAddress(address);
            dto.setUserAgent(browser.getName());

            messageService.sendAdminLoginLog(dto);
        }
    }
}

package com.demo.hotel.business.controller;

import com.demo.hotel.business.dto.LoginInfo;
import com.demo.hotel.business.dto.LoginParam;
import com.demo.hotel.commons.dto.ResponseResult;
import com.demo.hotel.commons.utils.MapperUtils;
import com.demo.hotel.commons.utils.OkHttpClientUtil;
import com.google.common.collect.Maps;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Objects;

/**
 * 登录管理
 */
//解决跨域问题
@CrossOrigin(origins = "*", maxAge = 3600)
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

    @PostMapping(value = "/user/login")
    public ResponseResult<Map<String, Object>> login(@RequestBody LoginParam loginParam) {
        Map<String, Object> result = Maps.newHashMap();

        //验证账号密码
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginParam.getUsername());

        if (userDetails == null || !passwordEncoder.matches(loginParam.getPassword(), userDetails.getPassword())) {
            return new ResponseResult<Map<String, Object>>(ResponseResult.CodeStatus.FAIL, "账号或密码错误", null);
        }
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseResult<Map<String, Object>>(ResponseResult.CodeStatus.OK, "登录成功！", result);
    }

    /**
     * @Description: 获取用户信息api
     * @Param: []
     * @return: com.demo.hotel.commons.dto.ResponseResult<com.demo.hotel.business.dto.LoginInfo>
     * @Author: syj
     * @Date: 2020/3/29
     */
    @GetMapping(value = "/user/info")
    public ResponseResult<LoginInfo> info() {
        //获取认证信息上下文的信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setName(authentication.getName());
        authentication.getName();
        return new ResponseResult<LoginInfo>(ResponseResult.CodeStatus.OK, "获取用户信息", loginInfo);
    }

    /**
     * @Description: 注销
     * @Param: [request]
     * @return: com.demo.hotel.commons.dto.ResponseResult<java.lang.Void>
     * @Author: syj
     * @Date: 2020/3/29
     */
    @PostMapping(value = "/user/logout")
    public ResponseResult<Void> logout(HttpServletRequest request) {
        String token = request.getParameter("access_token");
        OAuth2AccessToken oAuth2AccessToken = tokenStore.readAccessToken(token);
        tokenStore.removeAccessToken(oAuth2AccessToken);

        return new ResponseResult<Void>(ResponseResult.CodeStatus.OK, "用户注销", null);
    }
}
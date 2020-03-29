package com.demo.hotel.business.service;

import com.demo.hotel.provider.api.AdminService;
import com.demo.hotel.provider.domain.Admin;
import com.google.common.collect.Lists;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 自定义认证授权
 * <p>
 * Description:
 * </p>
 *
 * @author syj
 * @see com.demo.hotel.business.service
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    //@Reference(version = "1.0.0")
    //private AdminService adminService;

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "$2a$10$YNUV/BtCel2orbhgrxyPJeljdKVty6yTAL.Cj4v3XhwHWXBkgyPYW";


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        // 用户名匹配
        if (s.equals(USERNAME)) {
            List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("USER");
            grantedAuthorities.add(grantedAuthority);
            return new User(USERNAME, PASSWORD, grantedAuthorities);
        }
        // 用户名不匹配
        else {
            return null;
        }
    }
}
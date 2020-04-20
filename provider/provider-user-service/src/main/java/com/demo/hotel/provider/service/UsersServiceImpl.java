package com.demo.hotel.provider.service;

import com.demo.hotel.provider.domain.Users;

import javax.annotation.Resource;
import com.demo.hotel.provider.mapper.UsersMapper;
import com.demo.hotel.provider.api.UsersService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;

/**
 * @author syj
 */
@Service(version = "1.0.0")
public class UsersServiceImpl implements UsersService{

    @Resource
    private UsersMapper usersMapper;

    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public int insert(Users users) {
        //初始化用户信息
        initUser(users);
        return usersMapper.insert(users);
    }

    @Override
    public Users get(Long id) {
        return usersMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(Users users) {
        //获取原始信息
        Users oldUser = get(users.getId());
        //更新
        oldUser.setNickname(users.getNickname());
        oldUser.setUpdateTime(new Date());
        oldUser.setGender(users.getGender());
        oldUser.setName2(users.getName2());
        oldUser.setPhone2(users.getPhone2());

        //更新昵称 更新时间  性别 紧急联系人信息，手机号


        return usersMapper.updateByPrimaryKey(oldUser);
    }

    @Override
    public int modifyPassword(Long id, String password) {
        Users oldUsers = get(id);
        oldUsers.setPassword(passwordEncoder.encode(password));
        return usersMapper.updateByPrimaryKey(oldUsers);
    }

    @Override
    public int modifyIcon(Long id, String path) {
        Users oldUsers = get(id);
        oldUsers.setIcon(path);
        return usersMapper.updateByPrimaryKey(oldUsers);
    }

    /**
     * 初始化用户信息
     * @param users
     */
    private void initUser(Users users) {
        //初始化创建时间
        users.setCreatTime(new Date());
        users.setUpdateTime(new Date());

        //密码加密
        users.setPassword(passwordEncoder.encode(users.getPassword()));
    }
}

package com.demo.hotel.provider.service;

import com.demo.hotel.provider.domain.Admin;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

import com.demo.hotel.provider.mapper.AdminMapper;
import com.demo.hotel.provider.api.AdminService;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

/**
 * @author syj
 */
@Service(version = "1.0.0")
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public int insert(Admin admin) {
        //初始化用户对象
        initAdmin(admin);
        return adminMapper.insert(admin);
    }

    @Override
    public Admin get(Long id) {
        Example example = new Example(Admin.class);
        example.createCriteria().andEqualTo("id", id);
        return adminMapper.selectOneByExample(example);
    }

    @Override
    public Admin get(String email) {
        Example example = new Example(Admin.class);
        example.createCriteria().andEqualTo("email", email);
        return adminMapper.selectOneByExample(example);
    }

    @Override
    public Admin get(Admin admin) {
        return adminMapper.selectOne(admin);
    }

    @Override
    public int delete(String email) {
        Example example = new Example(Admin.class);
        example.createCriteria().andEqualTo("email", email);
        return adminMapper.deleteByExample(example);
    }

    @Override
    public int delete(Admin admin) {
        return adminMapper.delete(admin);
    }

    @Override
    public int update(Admin admin) {
        //获取原始信息
        Admin oldAdmin = get(admin.getId());
        //更新用户名 更新时间 手机号 性别
        oldAdmin.setUsername(admin.getUsername());
        oldAdmin.setUpdateTime(new Date());
        oldAdmin.setPhone(admin.getPhone());
        oldAdmin.setGender(admin.getGender());

        return adminMapper.updateByPrimaryKey(oldAdmin);
    }

    @Override
    public int modifyPassword(String email, String password) {
        Admin oldAdmin = get(email);
        oldAdmin.setPassword(passwordEncoder.encode(password));
        return adminMapper.updateByPrimaryKey(oldAdmin);
    }

    @Override
    public int modifyIcon(String email, String path) {
        Admin oldAdmin = get(email);
        oldAdmin.setIcon(path);
        return adminMapper.updateByPrimaryKey(oldAdmin);
    }

    /**
     * 初始化用户对象
     *
     * @param admin {@link Admin}
     */
    private void initAdmin(Admin admin) {
        //初始化创建时间
        admin.setCreateTime(new Date());
        admin.setUpdateTime(new Date());

        //密码加密
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
    }
}

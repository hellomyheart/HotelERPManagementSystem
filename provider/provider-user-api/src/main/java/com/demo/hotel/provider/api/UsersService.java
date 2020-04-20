package com.demo.hotel.provider.api;

import com.demo.hotel.provider.domain.Users;
import sun.rmi.runtime.Log;

/**
 * @author syj
 */
public interface UsersService {
    /**
     * 新增用户
     *
     * @param users
     * @return 大于0表示添加成功
     */
    int insert(Users users);


    /**
     * 获取用户信息
     *
     * @param id
     * @return
     */
    Users get(Long id);


    /**
     * 更新信息
     *
     * @param users
     * @return
     */
    int update(Users users);

    /**
     * 修改密码
     *
     * @param id
     * @param password
     * @return
     */
    int modifyPassword(Long id, String password);

    /**
     * 修改头像
     *
     * @param id
     * @param path
     * @return
     */
    int modifyIcon(Long id, String path);
}

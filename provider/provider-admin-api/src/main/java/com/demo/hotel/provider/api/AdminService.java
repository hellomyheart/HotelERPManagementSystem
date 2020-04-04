package com.demo.hotel.provider.api;

import com.demo.hotel.provider.domain.Admin;

/**
 * @author syj
 */
public interface AdminService {

    /**
     * 新增用户
     *
     * @param admin {@link Admin}
     * @return {@code int} 大于0表示添加成功
     */
    int insert(Admin admin);

    /**
     * 获取用户信息
     *
     * @param id 用户ID
     * @return {@link Admin}
     */
    Admin get(Long id);

    /**
     * 获取用户信息
     *
     * @param username 用户名
     * @return {@link Admin}
     */
    Admin get(String username);

    /**
     * 获取用户信息
     *
     * @param admin {@link Admin}
     * @return {@link Admin}
     */
    Admin get(Admin admin);

    /**
     * 删除用户
     *
     * @param username 用户名
     * @return {@code int} 大于0表示删除成功
     */
    int delete(String username);

    /**
     * 删除用户
     *
     * @return {@code int} 大于0表示删除成功
     */
    int delete(Long id);


    /**
     * 更新信息
     *
     * @param admin {@link Admin}
     * @return {@code int} 大于0表示更新成功
     */
    int update(Admin admin);

    /**
     * 修改密码
     *
     * @param username {@code String} 用户名
     * @param password {@code String} 明文密码
     * @return {@code int} 大于 0 则表示更新成功
     */
    int modifyPassword(String username, String password);

    /**
     * 修改头像
     *
     * @param username {@code String} 用户邮箱
     * @param path     {@code String} 头像地址
     * @return {@code int} 大于 0 则表示更新成功
     */
    int modifyIcon(String username, String path);
}

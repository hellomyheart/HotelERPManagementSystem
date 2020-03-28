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
     * @param email 用户邮箱
     * @return {@link Admin}
     */
    Admin get(String email);

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
     * @param email 用户邮箱
     * @return {@code int} 大于0表示删除成功
     */
    int delete(String email);

    /**
     * 删除用户
     *
     * @param admin {@link Admin}
     * @return {@code int} 大于0表示删除成功
     */
    int delete(Admin admin);


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
     * @param email {@code String} 用户邮箱
     * @param password {@code String} 明文密码
     * @return {@code int} 大于 0 则表示更新成功
     */
    int modifyPassword(String email, String password);

    /**
     * 修改头像
     *
     * @param email {@code String} 用户邮箱
     * @param path     {@code String} 头像地址
     * @return {@code int} 大于 0 则表示更新成功
     */
    int modifyIcon(String email, String path);
}

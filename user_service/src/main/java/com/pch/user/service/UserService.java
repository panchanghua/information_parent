package com.pch.user.service;

import com.pch.user.entity.User;
import com.pch.user.pojo.UserInfo;

import java.util.List;

/**
 * user(User)表服务接口
 *
 * @author makejava
 * @since 2020-04-05 10:12:09
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    User queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<User> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User update(User user);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 通过主键查询用户信息
     *
     * @param id 主键
     * @return 是否成功
     */
    UserInfo queryUserInfo(Integer id);
}
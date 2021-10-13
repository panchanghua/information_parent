package com.pch.user.service;

import com.pch.user.entity.TRole;

/**
 * user(User)表服务接口
 *
 * @author makejava
 * @since 2020-04-05 10:12:09
 */
public interface RoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TRole queryById(String id);
}

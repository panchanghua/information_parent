package com.pch.user.service;

import com.pch.user.entity.TPermission;

public interface PermissionService {
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TPermission queryById(String id);
}

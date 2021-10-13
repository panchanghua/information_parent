package com.pch.user.service.impl;

import com.pch.user.dao.TRolePermissionMapper;
import com.pch.user.entity.TRolePermission;
import com.pch.user.service.RolePermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RolePermissionServiceImpl implements RolePermissionService {

    @Resource
    TRolePermissionMapper rolePermissionMapper;

    public List<TRolePermission> queryPermissionsByRoleId(String id) {
        return rolePermissionMapper.selectPermissionsByRoleId(id);
    }
}

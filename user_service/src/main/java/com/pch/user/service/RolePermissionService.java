package com.pch.user.service;

import com.pch.user.entity.TRolePermission;

import java.util.List;

public interface RolePermissionService {
    public List<TRolePermission> queryPermissionsByRoleId(String id);
}

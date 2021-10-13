package com.pch.user.service;

import com.pch.user.entity.TUserRole;

public interface UserRoleService {
    TUserRole queryRoleByUserId(Integer id);

    Integer deleteByUserId(Integer id);

    Integer insert(TUserRole userRole);

    Integer updateRoleByUser(TUserRole userRole);
}

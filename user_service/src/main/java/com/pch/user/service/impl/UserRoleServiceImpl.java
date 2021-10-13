package com.pch.user.service.impl;

import com.pch.user.dao.TUserRoleMapper;
import com.pch.user.entity.TUserRole;
import com.pch.user.service.UserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Resource
    private TUserRoleMapper userRoleMapper;

    public TUserRole queryRoleByUserId(Integer id) {
        return userRoleMapper.selectByPrimaryKey(id);
    }

    public Integer deleteByUserId(Integer id) {
        return userRoleMapper.deleteByPrimaryKey(id);
    }

    public Integer insert(TUserRole userRole) {
        return userRoleMapper.insert(userRole);
    }

    public Integer updateRoleByUser(TUserRole userRole) {
        return userRoleMapper.updateByPrimaryKey(userRole);
    }
}

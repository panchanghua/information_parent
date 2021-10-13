package com.pch.user.service.impl;

import com.pch.user.dao.TRoleMapper;
import com.pch.user.dao.UserDao;
import com.pch.user.entity.TRole;
import com.pch.user.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private TRoleMapper roleMapper;

    public TRole queryById(String id) {
        return roleMapper.selectByPrimaryKey(id);
    }
}

package com.pch.user.service.impl;

import com.pch.user.dao.TPermissionMapper;
import com.pch.user.entity.TPermission;
import com.pch.user.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Resource
    TPermissionMapper permissionMapper;

    public TPermission queryById(String id) {
        return permissionMapper.selectByPrimaryKey(id);
    }
}

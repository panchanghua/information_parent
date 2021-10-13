package com.pch.security.service.impl;

import com.pch.security.domain.RolePermission;
import com.pch.security.domain.UserRole;
import com.pch.security.mapper.PermissionMapper;
import com.pch.security.mapper.RolePermissionMapper;
import com.pch.security.mapper.UserRoleMapper;
import com.pch.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserserviceImpl implements UserService {

    @Autowired
    UserRoleMapper userRoleMapper;

    @Autowired
    RolePermissionMapper rolePermissionMapper;

    @Autowired
    PermissionMapper permissionMapper;


    @Override

    //通过用户id获取用户角色 通过用户角色访问角色的权限 获取权限list
    public List<String> findPermissionsByUserid(String userId){
        //使用用户id获取用户的角色
        UserRole userRole = userRoleMapper.selectByPrimaryKey(userId);
        //根据角色获取角色的权限
        List<RolePermission> rolePermissions = rolePermissionMapper.selectByRoldId(userRole.getRoleId());
        //构造权限list
        List<String> list = new ArrayList<String>();
        rolePermissions.forEach(permission -> list.add(permission.getPermissionId()));
//        for (TRolePermission rolePermission:rolePermissions) {
//            list.add(rolePermission.getPermissionId());
//        }
        return permissionMapper.selectCodeById(list);
    }
}

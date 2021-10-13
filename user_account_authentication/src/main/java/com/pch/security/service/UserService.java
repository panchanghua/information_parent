package com.pch.security.service;

import java.util.List;

public interface UserService {

    //通过用户id获取用户角色 通过用户角色访问角色的权限 获取权限list
    List<String> findPermissionsByUserid(String userId);

}

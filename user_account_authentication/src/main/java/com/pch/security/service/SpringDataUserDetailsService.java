package com.pch.security.service;

import com.pch.security.mapper.UserMapper;
import com.pch.security.pojo.AuthUserDetails;
import com.pch.security.pojo.AuthUserPoJo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpringDataUserDetailsService implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;

    /**
     * 根据 用户名查询用户信息 查询数据库中的数据
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据用户名查询用户 然后返回user list对象
        List<com.pch.security.domain.User> list = userMapper.selectByUsername(username);
        System.out.println(username);
        System.out.println(list);
        com.pch.security.domain.User user = null;
        //如果有对象就将该对象构造为userDetails返回
        if (list != null && list.size() > 0 ){
            user = list.get(0);
            //使用用户id获取用户的权限 构造成String权限数组
            List<String> permissions = userService.findPermissionsByUserid(user.getId());
            String[] permission = new String[permissions.size()];
            permissions.toArray(permission);
            //构造userDetails
            UserDetails userDetails = User.withUsername(user.getUsername()).password(user.getPassword()).authorities(permission).build();
            return userDetails;
        }
        //没有查询到user对象就返回空自动抛出异常
        return null;

    }
}

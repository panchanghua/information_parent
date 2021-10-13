package com.pch.user.controller;

import com.pch.user.entity.TPermission;
import com.pch.user.entity.TRole;
import com.pch.user.entity.TRolePermission;
import com.pch.user.entity.TUserRole;
import com.pch.user.entity.User;
import com.pch.user.pojo.UserInfo;
import com.pch.user.service.PermissionService;
import com.pch.user.service.RolePermissionService;
import com.pch.user.service.RoleService;
import com.pch.user.service.UserRoleService;
import com.pch.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * user(User)表控制层
 *
 * @author makejava
 * @since 2020-04-05 10:12:10
 */
@RestController
@RequestMapping("user")
@CrossOrigin("*")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RolePermissionService rolePermissionService;

    @Autowired
    private PermissionService permissionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public User selectOne(Integer id) {
        return this.userService.queryById(id);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectUserInfo")
    public UserInfo selectUserInfo(Integer id) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUser(userService.queryById(id));
        if (userInfo.getUser() == null){
            return null;
        }
        TUserRole userRole = userRoleService.queryRoleByUserId(userInfo.getUser().getId());
        userInfo.setRole(roleService.queryById(userRole.getRoleId()));
        List<TRolePermission> rolePermissions = rolePermissionService.queryPermissionsByRoleId(userRole.getRoleId());
        List<TPermission> prmissions = new ArrayList<TPermission>();
        for ( TRolePermission rolePermission: rolePermissions ) {
            prmissions.add(permissionService.queryById(rolePermission.getPermissionId()));
        }
        userInfo.setPermissions(prmissions);
        return userInfo;
    }

    /**
     * 通过主键删除单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("deleteUserInfo")
    public String deleteUserInfo(Integer id) {
        userRoleService.deleteByUserId(id);
        userService.deleteById(id);
        return "success";
    }

    /**
     * 添加单条数据
     *
     * @param user 用户信息
     * @return 单条数据
     */
    @PostMapping(value = "addUserInfo")
    public Integer addUserInfo(User user) {
        System.out.println(user);
        BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bcryptPasswordEncoder.encode(user.getPassword()));
        User u = userService.insert(user);
        System.out.println(u);
        TUserRole userRole = new TUserRole();
        userRole.setRoleId("3");
        userRole.setUserId(user.getId());
        //获得系统时间.
        Date date = new Date();
        //将时间格式转换成符合Timestamp要求的格式.
        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        //把时间转换
        userRole.setCreateTime(Timestamp.valueOf(nowTime));
        userRole.setCreator("x");
        return userRoleService.insert(userRole);
    }

    /**
     * 更新单条数据
     *
     * @param user 用户信息
     * @return 单条数据
     */
    @PostMapping("updateUserInfo")
    public User updateUserInfo(User user) {
        System.out.println(user);
        return userService.update(user);
    }

    /**
     * 更新单条数据
     *
     * @param userRole 用户信息
     * @return 单条数据
     */
    @PostMapping("updateRoleInfo")
    public Integer updateRoleInfo(TUserRole userRole) {
        System.out.println(userRole);
        return userRoleService.updateRoleByUser(userRole);
    }
}
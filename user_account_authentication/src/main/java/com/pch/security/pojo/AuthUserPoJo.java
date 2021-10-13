package com.pch.security.pojo;

import com.pch.security.domain.Permission;
import com.pch.security.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @ClassName AuthUserPoJo
 * @Description TODO
 * @Author liuheming
 * @Date 2019/5/6 11:50
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
public class AuthUserPoJo {
    private String userId;
    private String userName;
    private String passWord;
    private String status;
    private List<Role> roleInfos;
    private List<Permission> permissionInfos;
    AuthUserPoJo(){

    }
}

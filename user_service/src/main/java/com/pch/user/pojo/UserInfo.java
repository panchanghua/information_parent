package com.pch.user.pojo;

import com.pch.user.entity.TPermission;
import com.pch.user.entity.TRole;
import com.pch.user.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class UserInfo {
    User user;
    TRole role;
    List<TPermission> permissions;
}

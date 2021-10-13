package com.pch.security.domain;

import lombok.Data;

@Data
/**
 * RolePermission class
 *
 * @author panchanghua
 * @date 2020/3/6
 */
public class RolePermission {

    private static final long serialVersionUID = 1L;

    private String roleId;

    private String permissionId;
}
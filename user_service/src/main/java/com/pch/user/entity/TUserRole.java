package com.pch.user.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TUserRole {
    private Integer userId;

    private String roleId;

    private Date createTime;

    private String creator;
}
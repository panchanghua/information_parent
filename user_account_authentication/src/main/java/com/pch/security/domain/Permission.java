package com.pch.security.domain;

import lombok.Data;

import java.io.Serializable;

@Data
/**
 * Permission class
 *
 * @author panchanghua
 * @date 2020/3/6
 */
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 权限id
     */
    private String id;

    /**
     * 拥用的权限
     */
    private String code;
    /**
     * 说明
     */
    private String description;
    /**
     * 接口路径
     */
    private String url;
    /**
     * 接口类型
     */
    private String method;
}
package com.pch.user.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * user(User)实体类
 *
 * @author makejava
 * @since 2020-04-05 10:12:07
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -72221483502835640L;
    /**
    * id
    */
    private Integer id;
    /**
    * username
    */
    private String username;
    /**
    * password
    */
    private String password;
    /**
    * fullname
    */
    private String fullname;
    /**
    * mobile
    */
    private String mobile;

}
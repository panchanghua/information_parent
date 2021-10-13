package com.pch.security.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
/**
 * User class
 *
 * @author panchanghua
 * @date 2020/3/6
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * id
    */
    private String id;

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
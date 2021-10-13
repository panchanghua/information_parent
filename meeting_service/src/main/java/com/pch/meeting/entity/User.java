package com.pch.meeting.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
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
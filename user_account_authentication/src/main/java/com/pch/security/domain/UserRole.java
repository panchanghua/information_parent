package com.pch.security.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
/**
 * UserRole class
 *
 * @author panchanghua
 * @date 2020/3/6
 */
public class UserRole implements Serializable {
    /**
     * 用户id
     */
    private String userId;

    /**
     * 角色id
     */
    private String roleId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建者
     */
    private String creator;
}
package com.pch.menu.entity;

import lombok.ToString;

import java.io.Serializable;

/**
 * (Menu)实体类
 *
 * @author makejava
 * @since 2020-03-21 12:11:14
 */
@ToString
public class Menu implements Serializable {
    private static final long serialVersionUID = -43082259642769861L;
    /**
    * 菜单id
    */
    private Integer id;
    /**
    * 父节点id
    */
    private Integer parentId;
    /**
    * 菜单名称
    */
    private String menuName;
    /**
    * 菜单路径
    */
    private String menuUrl;
    /**
    * 菜单状态 1-有效；0-无效
    */
    private Object status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

}
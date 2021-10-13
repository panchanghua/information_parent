package com.pch.menu.entity;

import java.util.List;

public class MenuList extends Menu {


    public MenuList(Menu menu){
        this.setId(menu.getId());
        this.setMenuName(menu.getMenuName());
        this.setMenuUrl(menu.getMenuUrl());
        this.setParentId(menu.getParentId());
        this.setStatus(menu.getStatus());
    }

    List<Menu> children;

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }
}

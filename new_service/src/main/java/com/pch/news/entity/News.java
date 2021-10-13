package com.pch.news.entity;

import java.io.Serializable;

/**
 * (News)实体类
 *
 * @author makejava
 * @since 2020-03-29 21:33:59
 */
public class News implements Serializable {
    private static final long serialVersionUID = 152410401296242633L;
    
    private String newId;
    
    private String newName;
    
    private String newDate;
    
    private String newData;


    public String getNewId() {
        return newId;
    }

    public void setNewId(String newId) {
        this.newId = newId;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getNewDate() {
        return newDate;
    }

    public void setNewDate(String newDate) {
        this.newDate = newDate;
    }

    public String getNewData() {
        return newData;
    }

    public void setNewData(String newData) {
        this.newData = newData;
    }

}
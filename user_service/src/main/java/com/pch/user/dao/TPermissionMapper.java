package com.pch.user.dao;

import com.pch.user.entity.TPermission;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TPermissionMapper {
    int deleteByPrimaryKey(String id);

    int insert(TPermission record);

    int insertSelective(TPermission record);

    TPermission selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TPermission record);

    int updateByPrimaryKey(TPermission record);
}
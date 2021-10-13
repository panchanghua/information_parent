package com.pch.user.dao;

import com.pch.user.entity.TRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TRoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(TRole record);

    int insertSelective(TRole record);

    TRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TRole record);

    int updateByPrimaryKey(TRole record);
}
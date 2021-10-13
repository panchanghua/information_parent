package com.pch.user.dao;

import com.pch.user.entity.TUserRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TUserRoleMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(TUserRole record);

    int insertSelective(TUserRole record);

    TUserRole selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(TUserRole record);

    int updateByPrimaryKey(TUserRole record);
}
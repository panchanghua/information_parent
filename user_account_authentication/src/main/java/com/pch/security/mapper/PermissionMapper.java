package com.pch.security.mapper;

import com.pch.security.domain.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
/**
 * PermissionMapper interface
 *
 * @author panchanghua
 * @date 2020/3/6
 */
public interface PermissionMapper {

    int deleteByPrimaryKey(String id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    List<String> selectCodeById(List<String> id);
}
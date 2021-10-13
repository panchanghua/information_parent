package com.pch.security.mapper;

import com.pch.security.domain.RolePermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
/**
 * RolePermissionMapper interface
 *
 * @author panchanghua
 * @date 2020/3/6
 */
public interface RolePermissionMapper {

    int deleteByPrimaryKey(@Param("roleId") String roleId, @Param("permissionId") String permissionId);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    List<RolePermission> selectByRoldId(String roleId);
}
package com.pch.security.mapper;

import com.pch.security.domain.Role;
import org.apache.ibatis.annotations.Mapper;

@Mapper
/**
 * RoleMapper interface
 *
 * @author panchanghua
 * @date 2020/3/6
 */
public interface RoleMapper {
    /**
     * delete data by rule id
     *
     * @param id id
     * @return int
     */
    int deleteByPrimaryKey(String id);

    /**
     * insert data by rule id
     *
     * @param record id
     * @return int
     */
    int insert(Role record);
    /**
     * fetch data by rule id
     *
     * @param record id
     * @return int
     */
    int insertSelective(Role record);
    /**
     * select data by rule id
     *
     * @param id id
     * @return int
     */
    Role selectByPrimaryKey(String id);
    /**
     * update data by rule
     *
     * @param record id
     * @return int
     */
    int updateByPrimaryKeySelective(Role record);
    /**
     * update data by rule id
     *
     * @param record id
     * @return int
     */
    int updateByPrimaryKey(Role record);
}
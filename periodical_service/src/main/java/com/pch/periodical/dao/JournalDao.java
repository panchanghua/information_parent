package com.pch.periodical.dao;

import com.pch.periodical.entity.Journal;
import com.pch.periodical.entity.Search;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Journal)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-19 10:56:04
 */
@Mapper
public interface JournalDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Journal queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Journal> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Journal> queryInfoByLimit(@Param("offset") int offset, @Param("limit") int limit,@Param("name") String name);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param journal 实例对象
     * @return 对象列表
     */
    List<Journal> queryAll(Journal journal);

    /**
     * 新增数据
     *
     * @param journal 实例对象
     * @return 影响行数
     */
    int insert(Journal journal);

    /**
     * 修改数据
     *
     * @param journal 实例对象
     * @return 影响行数
     */
    int update(Journal journal);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     *
     *
     * @param name
     * @return
     */
    Integer countByName(@Param("name") String name);

    List<Journal> queryByOptions(@Param("offset") int offset, @Param("limit") int limit, @Param("search")Search search);
}
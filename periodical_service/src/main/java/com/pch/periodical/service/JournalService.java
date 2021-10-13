package com.pch.periodical.service;

import com.pch.periodical.entity.Journal;
import com.pch.periodical.entity.JournalResult;
import com.pch.periodical.entity.Search;

import java.util.List;

/**
 * (Journal)表服务接口
 *
 * @author makejava
 * @since 2020-04-19 10:56:05
 */
public interface JournalService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Journal queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Journal> queryAllByLimit(int offset, int limit);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    JournalResult queryInfoByLimit(int offset, int limit,String name);

    /**
     * 新增数据
     *
     * @param journal 实例对象
     * @return 实例对象
     */
    Journal insert(Journal journal);

    /**
     * 修改数据
     *
     * @param journal 实例对象
     * @return 实例对象
     */
    Journal update(Journal journal);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    Integer countByName(String name);

    JournalResult queryByOptions(int offset, int limit, Search search);
}
package com.pch.menu.service;

import com.pch.menu.entity.Menu;
import com.pch.menu.entity.MenuList;

import java.util.List;

/**
 * (Menu)表服务接口
 *
 * @author makejava
 * @since 2020-03-21 12:11:18
 */
public interface MenuService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Menu queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Menu> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param menu 实例对象
     * @return 实例对象
     */
    Menu insert(Menu menu);

    /**
     * 修改数据
     *
     * @param menu 实例对象
     * @return 实例对象
     */
    Menu update(Menu menu);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 查询菜单表
     * @return 实例链表
     */
    List<MenuList> queryAllMenu();
}
package com.pch.menu.service.impl;

import com.pch.menu.entity.Menu;
import com.pch.menu.dao.MenuDao;
import com.pch.menu.entity.MenuList;
import com.pch.menu.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (Menu)表服务实现类
 *
 * @author makejava
 * @since 2020-03-21 12:11:18
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService {
    @Resource
    private MenuDao menuDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public Menu queryById(Integer id) {
        return this.menuDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    public List<Menu> queryAllByLimit(int offset, int limit) {
        return this.menuDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param menu 实例对象
     * @return 实例对象
     */
    public Menu insert(Menu menu) {
        this.menuDao.insert(menu);
        return menu;
    }

    /**
     * 修改数据
     *
     * @param menu 实例对象
     * @return 实例对象
     */
    public Menu update(Menu menu) {
        this.menuDao.update(menu);
        return this.queryById(menu.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteById(Integer id) {
        return this.menuDao.deleteById(id) > 0;
    }

    /**
     * 查询菜单表
     * @return 实例链表
     */
    public List<MenuList> queryAllMenu() {
        List<Menu> list = this.menuDao.queryByParentId(1);
        List<MenuList> menuList = new ArrayList<MenuList>();
        for (Menu m:list) {
            MenuList menu = new MenuList(m);
            menu.setChildren(this.menuDao.queryByParentId(m.getId()));
            menuList.add(menu);
        }
        for (int i = 0; i < list.size(); i++ ) {

        }
        return menuList;
    }
}
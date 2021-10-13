package com.pch.menu.controller;

import com.pch.menu.entity.Menu;
import com.pch.menu.entity.MenuList;
import com.pch.menu.service.MenuService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Menu)表控制层
 *
 * @author makejava
 * @since 2020-03-21 12:11:19
 */
@RestController
@RequestMapping("menu")
public class MenuController {
    /**
     * 服务对象
     */
    @Resource
    private MenuService menuService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Menu selectOne(Integer id) {
        return this.menuService.queryById(id);
    }

    @GetMapping("select")
    public List<MenuList> select() {
        return this.menuService.queryAllMenu();
    }

}
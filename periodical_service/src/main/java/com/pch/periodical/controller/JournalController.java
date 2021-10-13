package com.pch.periodical.controller;

import com.pch.periodical.entity.Journal;
import com.pch.periodical.entity.JournalResult;
import com.pch.periodical.entity.Search;
import com.pch.periodical.service.JournalService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Journal)表控制层
 *
 * @author makejava
 * @since 2020-04-19 10:56:06
 */
@RestController
@RequestMapping("periodical")
public class JournalController {
    /**
     * 服务对象
     */
    @Resource
    private JournalService journalService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public Journal selectOne(Integer id) {
        return this.journalService.queryById(id);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param
     * @return 单条数据
     */
    @GetMapping("/selectByLimit")
    public List<Journal> selectList(@RequestParam(defaultValue = "1") int pageNum,
                                    @RequestParam(defaultValue = "20") int pageSize) {
        return this.journalService.queryAllByLimit((pageNum - 1) * pageSize, pageSize);
    }

    /**
     * 通过名称模糊查询数据
     *
     * @param
     * @return list
     */
    @GetMapping("/selectInfoByLimit")
    public JournalResult selectInfoList(@RequestParam(defaultValue = "1") int pageNum,
                                    @RequestParam(defaultValue = "20") int pageSize,@RequestParam(defaultValue = "") String name) {
        return this.journalService.queryInfoByLimit((pageNum - 1) * pageSize, pageSize,name);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param
     * @return 单条数据
     */
    @GetMapping("/countByName")
    public Integer countByName(@RequestParam(defaultValue = "") String name) {
        return this.journalService.countByName(name);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param
     * @return 单条数据
     */
    @PostMapping("/advancedSearch")
    public JournalResult advancedSearch(@RequestParam(defaultValue = "1") int pageNum,
                                        @RequestParam(defaultValue = "20") int pageSize, Search search) {
        return this.journalService.queryByOptions((pageNum - 1) * pageSize, pageSize,search);
    }
}
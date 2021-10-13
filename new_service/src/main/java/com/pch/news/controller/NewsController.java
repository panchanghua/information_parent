package com.pch.news.controller;

import com.pch.news.entity.News;
import com.pch.news.pojo.NewInfo;
import com.pch.news.service.NewsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * (News)表控制层
 *
 * @author makejava
 * @since 2020-03-29 21:34:02
 */
@RestController
@RequestMapping("news")
public class NewsController {
    /**
     * 服务对象
     */
    @Resource
    private NewsService newsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectInfoById")
    public News selectOne(String id) {
        return this.newsService.queryById(id);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param
     * @return 单条数据
     */
    @GetMapping("/selectByLimit")
    public List<NewInfo> selectList(@RequestParam(defaultValue = "1") int pageNum,
                                    @RequestParam(defaultValue = "8") int pageSize) {
        return this.newsService.queryInfoByLimit((pageNum - 1) * pageSize, pageSize);
    }

}
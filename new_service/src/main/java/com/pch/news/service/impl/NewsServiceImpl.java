package com.pch.news.service.impl;

import com.pch.news.dao.NewsDao;
import com.pch.news.entity.News;
import com.pch.news.pojo.NewInfo;
import com.pch.news.service.NewsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (News)表服务实现类
 *
 * @author makejava
 * @since 2020-03-29 21:34:02
 */
@Service("newsService")
public class NewsServiceImpl implements NewsService {
    @Resource
    private NewsDao newsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param newId 主键
     * @return 实例对象
     */
    public News queryById(String newId) {
        return this.newsDao.queryById(newId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    public List<News> queryAllByLimit(int offset, int limit) {
        return this.newsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    public List<NewInfo> queryInfoByLimit(int offset, int limit) {
        return this.newsDao.queryInfoByLimit(offset, limit);
    }
    /**
     * 新增数据
     *
     * @param news 实例对象
     * @return 实例对象
     */
    public News insert(News news) {
        this.newsDao.insert(news);
        return news;
    }

    /**
     * 修改数据
     *
     * @param news 实例对象
     * @return 实例对象
     */
    public News update(News news) {
        this.newsDao.update(news);
        return this.queryById(news.getNewId());
    }

    /**
     * 通过主键删除数据
     *
     * @param newId 主键
     * @return 是否成功
     */
    public boolean deleteById(String newId) {
        return this.newsDao.deleteById(newId) > 0;
    }
}
package com.pch.periodical.service.impl;

import com.pch.periodical.entity.Journal;
import com.pch.periodical.dao.JournalDao;
import com.pch.periodical.entity.JournalResult;
import com.pch.periodical.entity.Search;
import com.pch.periodical.service.JournalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Journal)表服务实现类
 *
 * @author makejava
 * @since 2020-04-19 10:56:05
 */
@Service("journalService")
public class JournalServiceImpl implements JournalService {
    @Resource
    private JournalDao journalDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Journal queryById(Integer id) {
        return this.journalDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Journal> queryAllByLimit(int offset, int limit) {
        return this.journalDao.queryAllByLimit(offset, limit);
    }

    @Override
    public JournalResult queryInfoByLimit(int offset, int limit,String name) {
        JournalResult journalResult = new JournalResult();
        journalResult.setJournals(this.journalDao.queryInfoByLimit(offset, limit, name));
        journalResult.setCount(journalResult.getJournals().size());
        return journalResult;
    }

    /**
     * 新增数据
     *
     * @param journal 实例对象
     * @return 实例对象
     */
    @Override
    public Journal insert(Journal journal) {
        this.journalDao.insert(journal);
        return journal;
    }

    /**
     * 修改数据
     *
     * @param journal 实例对象
     * @return 实例对象
     */
    @Override
    public Journal update(Journal journal) {
        this.journalDao.update(journal);
        return this.queryById(journal.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.journalDao.deleteById(id) > 0;
    }

    @Override
    public Integer countByName(String name) {
        return this.journalDao.countByName(name);
    }

    @Override
    public JournalResult queryByOptions(int offset, int limit, Search search) {
        JournalResult journalResult = new JournalResult();
        journalResult.setJournals(this.journalDao.queryByOptions(offset, limit, search));
        journalResult.setCount(journalResult.getJournals().size());
        return journalResult;
    }
}
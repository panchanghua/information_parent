package com.pch.meeting.service.impl;

import com.pch.meeting.entity.ConferenceInfo;
import com.pch.meeting.dao.ConferenceInfoDao;
import com.pch.meeting.service.ConferenceInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ConferenceInfo)表服务实现类
 *
 * @author makejava
 * @since 2020-03-10 14:36:27
 */
@Service("conferenceInfoService")
public class ConferenceInfoServiceImpl implements ConferenceInfoService {
    @Resource
    private ConferenceInfoDao conferenceInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param conferenceid 主键
     * @return 实例对象
     */
    @Override
    public ConferenceInfo queryById(String conferenceid) {
        return this.conferenceInfoDao.queryById(conferenceid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ConferenceInfo> queryAllByLimit(int offset, int limit) {
        return this.conferenceInfoDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param conferenceInfo 实例对象
     * @return 实例对象
     */
    @Override
    public ConferenceInfo insert(ConferenceInfo conferenceInfo) {
        this.conferenceInfoDao.insert(conferenceInfo);
        return conferenceInfo;
    }

    /**
     * 修改数据
     *
     * @param conferenceInfo 实例对象
     * @return 实例对象
     */
    @Override
    public ConferenceInfo update(ConferenceInfo conferenceInfo) {
        this.conferenceInfoDao.update(conferenceInfo);
        return this.queryById(conferenceInfo.getConferenceid());
    }

    /**
     * 通过主键删除数据
     *
     * @param conferenceid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String conferenceid) {
        return this.conferenceInfoDao.deleteById(conferenceid) > 0;
    }
}
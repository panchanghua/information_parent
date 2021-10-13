package com.pch.meeting.service.impl;

import com.pch.meeting.entity.MeetingInfo;
import com.pch.meeting.dao.MeetingInfoDao;
import com.pch.meeting.service.MeetingInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MeetingInfo)表服务实现类
 *
 * @author makejava
 * @since 2020-03-10 14:02:17
 */
@Service("meetingInfoService")
public class MeetingInfoServiceImpl implements MeetingInfoService {
    @Resource
    private MeetingInfoDao meetingInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public MeetingInfo queryById(Integer id) {
        return this.meetingInfoDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<MeetingInfo> queryAllByLimit(int offset, int limit) {
        return this.meetingInfoDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param meetingInfo 实例对象
     * @return 实例对象
     */
    @Override
    public MeetingInfo insert(MeetingInfo meetingInfo) {
        this.meetingInfoDao.insert(meetingInfo);
        return meetingInfo;
    }

    /**
     * 修改数据
     *
     * @param meetingInfo 实例对象
     * @return 实例对象
     */
    @Override
    public MeetingInfo update(MeetingInfo meetingInfo) {
        this.meetingInfoDao.update(meetingInfo);
        return this.queryById(meetingInfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.meetingInfoDao.deleteById(id) > 0;
    }
}
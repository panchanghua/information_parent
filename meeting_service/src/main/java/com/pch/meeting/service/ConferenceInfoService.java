package com.pch.meeting.service;

import com.pch.meeting.entity.ConferenceInfo;
import java.util.List;

/**
 * (ConferenceInfo)表服务接口
 *
 * @author makejava
 * @since 2020-03-10 14:36:27
 */
public interface ConferenceInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param conferenceid 主键
     * @return 实例对象
     */
    ConferenceInfo queryById(String conferenceid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ConferenceInfo> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param conferenceInfo 实例对象
     * @return 实例对象
     */
    ConferenceInfo insert(ConferenceInfo conferenceInfo);

    /**
     * 修改数据
     *
     * @param conferenceInfo 实例对象
     * @return 实例对象
     */
    ConferenceInfo update(ConferenceInfo conferenceInfo);

    /**
     * 通过主键删除数据
     *
     * @param conferenceid 主键
     * @return 是否成功
     */
    boolean deleteById(String conferenceid);

}
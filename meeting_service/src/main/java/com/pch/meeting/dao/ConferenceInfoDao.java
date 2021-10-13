package com.pch.meeting.dao;

import com.pch.meeting.entity.ConferenceInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (ConferenceInfo)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-10 14:36:27
 */
@Mapper
public interface ConferenceInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param conferenceid 主键
     * @return 实例对象
     */
    ConferenceInfo queryById(String conferenceid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ConferenceInfo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param conferenceInfo 实例对象
     * @return 对象列表
     */
    List<ConferenceInfo> queryAll(ConferenceInfo conferenceInfo);

    /**
     * 新增数据
     *
     * @param conferenceInfo 实例对象
     * @return 影响行数
     */
    int insert(ConferenceInfo conferenceInfo);

    /**
     * 修改数据
     *
     * @param conferenceInfo 实例对象
     * @return 影响行数
     */
    int update(ConferenceInfo conferenceInfo);

    /**
     * 通过主键删除数据
     *
     * @param conferenceid 主键
     * @return 影响行数
     */
    int deleteById(String conferenceid);

}
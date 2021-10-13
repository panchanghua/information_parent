package com.pch.meeting.dao;

import com.pch.meeting.entity.MeetingInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (MeetingInfo)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-10 14:02:11
 */
@Mapper
public interface MeetingInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MeetingInfo queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MeetingInfo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param meetingInfo 实例对象
     * @return 对象列表
     */
    List<MeetingInfo> queryAll(MeetingInfo meetingInfo);

    /**
     * 新增数据
     *
     * @param meetingInfo 实例对象
     * @return 影响行数
     */
    int insert(MeetingInfo meetingInfo);

    /**
     * 修改数据
     *
     * @param meetingInfo 实例对象
     * @return 影响行数
     */
    int update(MeetingInfo meetingInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}
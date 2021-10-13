package com.pch.meeting.controller;

import com.pch.meeting.entity.ConferenceInfo;
import com.pch.meeting.service.ConferenceInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (ConferenceInfo)表控制层
 *
 * @author makejava
 * @since 2020-03-10 14:36:27
 */
@RestController
@RequestMapping("conferenceInfo")
public class ConferenceInfoController {
    /**
     * 服务对象
     */
    @Resource
    private ConferenceInfoService conferenceInfoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public ConferenceInfo selectOne(String id) {
        return this.conferenceInfoService.queryById(id);
    }

}
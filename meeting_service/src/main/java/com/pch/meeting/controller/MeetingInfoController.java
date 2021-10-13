package com.pch.meeting.controller;

import com.github.pagehelper.PageHelper;
import com.pch.meeting.entity.MeetingInfo;
import com.pch.meeting.service.MeetingInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MeetingInfo)表控制层
 *
 * @author makejava
 * @since 2020-03-10 14:02:18
 */
@RestController
@RequestMapping("meetingInfo")
public class MeetingInfoController {
    /**
     * 服务对象
     */
    @Resource
    private MeetingInfoService meetingInfoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MeetingInfo selectOne(Integer id) {
        return this.meetingInfoService.queryById(id);
    }


    @GetMapping("/selectByLimit")
    public List<MeetingInfo> manageMember(@RequestParam(defaultValue = "1") int pageNum,
                                          @RequestParam(defaultValue = "10") int pageSize){
        //PageHelper.startPage(pageNum,pageSize);
        return meetingInfoService.queryAllByLimit((pageNum - 1) * pageSize, pageSize);
    }

}
package com.pch.meeting.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * (MeetingInfo)实体类
 *
 * @author makejava
 * @since 2020-03-10 14:02:10
 */
@Data
@ToString
public class MeetingInfo implements Serializable {
    private static final long serialVersionUID = -74293240740771062L;
    
    private Integer id;
    
    private String logo;
    
    private String meetingName;
    
    private String conferenceid;
    
    private String included;
    
    private String place;
    
    private String startTime;
    
    private String contribute;
    
    private String register;

}
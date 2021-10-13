package com.pch.meeting.entity;

import java.io.Serializable;

/**
 * (ConferenceInfo)实体类
 *
 * @author makejava
 * @since 2020-03-10 14:36:27
 */
public class ConferenceInfo implements Serializable {
    private static final long serialVersionUID = 510732998704689529L;
    
    private String conferenceid;
    
    private String conferenceTitle;
    
    private String conferenceSubtitle;
    
    private String conferenceInfo;
    
    private String conferenceImportdate;
    
    private String conferencePaper;
    
    private String conferenceContact;


    public String getConferenceid() {
        return conferenceid;
    }

    public void setConferenceid(String conferenceid) {
        this.conferenceid = conferenceid;
    }

    public String getConferenceTitle() {
        return conferenceTitle;
    }

    public void setConferenceTitle(String conferenceTitle) {
        this.conferenceTitle = conferenceTitle;
    }

    public String getConferenceSubtitle() {
        return conferenceSubtitle;
    }

    public void setConferenceSubtitle(String conferenceSubtitle) {
        this.conferenceSubtitle = conferenceSubtitle;
    }

    public String getConferenceInfo() {
        return conferenceInfo;
    }

    public void setConferenceInfo(String conferenceInfo) {
        this.conferenceInfo = conferenceInfo;
    }

    public String getConferenceImportdate() {
        return conferenceImportdate;
    }

    public void setConferenceImportdate(String conferenceImportdate) {
        this.conferenceImportdate = conferenceImportdate;
    }

    public String getConferencePaper() {
        return conferencePaper;
    }

    public void setConferencePaper(String conferencePaper) {
        this.conferencePaper = conferencePaper;
    }

    public String getConferenceContact() {
        return conferenceContact;
    }

    public void setConferenceContact(String conferenceContact) {
        this.conferenceContact = conferenceContact;
    }

}
package com.pch.periodical.entity;

import java.io.Serializable;

/**
 * (Journal)实体类
 *
 * @author makejava
 * @since 2020-04-19 10:56:03
 */
public class Journal implements Serializable {
    private static final long serialVersionUID = -12836623932093699L;
    
    private Integer id;
    
    private String journalId;
    
    private String journalPicture;
    
    private String journalName;
    
    private String journalCreateTime;
    
    private String journalEditor;
    
    private String journalTelephone;
    
    private String journalEmail;
    
    private String journalWebsite;
    
    private String journalSponsor;
    
    private String journalAdminister;
    
    private String journalSubscribe;
    
    private String journalIntroduction;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJournalId() {
        return journalId;
    }

    public void setJournalId(String journalId) {
        this.journalId = journalId;
    }

    public String getJournalPicture() {
        return journalPicture;
    }

    public void setJournalPicture(String journalPicture) {
        this.journalPicture = journalPicture;
    }

    public String getJournalName() {
        return journalName;
    }

    public void setJournalName(String journalName) {
        this.journalName = journalName;
    }

    public String getJournalCreateTime() {
        return journalCreateTime;
    }

    public void setJournalCreateTime(String journalCreateTime) {
        this.journalCreateTime = journalCreateTime;
    }

    public String getJournalEditor() {
        return journalEditor;
    }

    public void setJournalEditor(String journalEditor) {
        this.journalEditor = journalEditor;
    }

    public String getJournalTelephone() {
        return journalTelephone;
    }

    public void setJournalTelephone(String journalTelephone) {
        this.journalTelephone = journalTelephone;
    }

    public String getJournalEmail() {
        return journalEmail;
    }

    public void setJournalEmail(String journalEmail) {
        this.journalEmail = journalEmail;
    }

    public String getJournalWebsite() {
        return journalWebsite;
    }

    public void setJournalWebsite(String journalWebsite) {
        this.journalWebsite = journalWebsite;
    }

    public String getJournalSponsor() {
        return journalSponsor;
    }

    public void setJournalSponsor(String journalSponsor) {
        this.journalSponsor = journalSponsor;
    }

    public String getJournalAdminister() {
        return journalAdminister;
    }

    public void setJournalAdminister(String journalAdminister) {
        this.journalAdminister = journalAdminister;
    }

    public String getJournalSubscribe() {
        return journalSubscribe;
    }

    public void setJournalSubscribe(String journalSubscribe) {
        this.journalSubscribe = journalSubscribe;
    }

    public String getJournalIntroduction() {
        return journalIntroduction;
    }

    public void setJournalIntroduction(String journalIntroduction) {
        this.journalIntroduction = journalIntroduction;
    }

}
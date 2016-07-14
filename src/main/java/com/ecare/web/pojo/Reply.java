package com.ecare.web.pojo;

import java.util.Date;

public class Reply {
    private Integer replyid;

    private String replybody;

    private Date replytime;

    private Integer replypostid;

    private Integer replyuserid;

    public Integer getReplyid() {
        return replyid;
    }

    public void setReplyid(Integer replyid) {
        this.replyid = replyid;
    }

    public String getReplybody() {
        return replybody;
    }

    public void setReplybody(String replybody) {
        this.replybody = replybody == null ? null : replybody.trim();
    }

    public Date getReplytime() {
        return replytime;
    }

    public void setReplytime(Date replytime) {
        this.replytime = replytime;
    }

    public Integer getReplypostid() {
        return replypostid;
    }

    public void setReplypostid(Integer replypostid) {
        this.replypostid = replypostid;
    }

    public Integer getReplyuserid() {
        return replyuserid;
    }

    public void setReplyuserid(Integer replyuserid) {
        this.replyuserid = replyuserid;
    }
}
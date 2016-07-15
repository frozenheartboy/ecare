package com.ecare.web.pojo;

import java.util.Date;

public class Reply {
    private Integer replyid;

    private String replybody;

    private Date replytime;

    private Integer replypostid;

    private Integer replyuserid;

    private Integer replylike;

    private String re1;

    private String re2;

    private String re3;

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

    public Integer getReplylike() {
        return replylike;
    }

    public void setReplylike(Integer replylike) {
        this.replylike = replylike;
    }

    public String getRe1() {
        return re1;
    }

    public void setRe1(String re1) {
        this.re1 = re1 == null ? null : re1.trim();
    }

    public String getRe2() {
        return re2;
    }

    public void setRe2(String re2) {
        this.re2 = re2 == null ? null : re2.trim();
    }

    public String getRe3() {
        return re3;
    }

    public void setRe3(String re3) {
        this.re3 = re3 == null ? null : re3.trim();
    }
}
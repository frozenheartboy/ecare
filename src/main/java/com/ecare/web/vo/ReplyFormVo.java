package com.ecare.web.vo;

import java.util.Date;

/**
 * Created by L on 2016/7/17.
 */
public class ReplyFormVo {
    private Integer replyId;

    private String replyBody;

    private Date replyCreateTime;

    private Integer replyPostId;

    private Integer replyUserId;

    private Integer replyLikes;

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public String getReplyBody() {
        return replyBody;
    }

    public void setReplyBody(String replyBody) {
        this.replyBody = replyBody;
    }

    public Date getReplyCreateTime() {
        return replyCreateTime;
    }

    public void setReplyCreateTime(Date replyCreateTime) {
        this.replyCreateTime = replyCreateTime;
    }

    public Integer getReplyPostId() {
        return replyPostId;
    }

    public void setReplyPostId(Integer replyPostId) {
        this.replyPostId = replyPostId;
    }

    public Integer getReplyUserId() {
        return replyUserId;
    }

    public void setReplyUserId(Integer replyUserId) {
        this.replyUserId = replyUserId;
    }

    public Integer getReplyLikes() {
        return replyLikes;
    }

    public void setReplyLikes(Integer replyLikes) {
        this.replyLikes = replyLikes;
    }
}

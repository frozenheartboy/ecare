package com.ecare.web.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by L on 2016/7/17.
 */
public class PostVo implements Serializable{
    private static final long serialVersionUID = 5783068969730871211L;
    private Integer postId;

    private String postTitle;

    private String postBody;

    private Date postCreateTime;

    private Date postEditTime;

    private Date postLastTime;
    private String TimeStatus;

    private Integer postUserId;

    private Integer postClassId;


    private Integer postLikes;

    private Integer postViews;

    private List<String> photoUrl;

    private boolean isLiked;
    private boolean isFavorite;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }

    public Date getPostCreateTime() {
        return postCreateTime;
    }

    public void setPostCreateTime(Date postCreateTime) {
        this.postCreateTime = postCreateTime;
    }

    public Date getPostEditTime() {
        return postEditTime;
    }

    public void setPostEditTime(Date postEditTime) {
        this.postEditTime = postEditTime;
    }

    public Date getPostLastTime() {
        return postLastTime;
    }

    public void setPostLastTime(Date postLastTime) {
        this.postLastTime = postLastTime;
    }

    public String getTimeStatus() {
        return TimeStatus;
    }

    public void setTimeStatus(String timeStatus) {
        TimeStatus = timeStatus;
    }

    public Integer getPostUserId() {
        return postUserId;
    }

    public void setPostUserId(Integer postUserId) {
        this.postUserId = postUserId;
    }

    public Integer getPostClassId() {
        return postClassId;
    }

    public void setPostClassId(Integer postClassId) {
        this.postClassId = postClassId;
    }


    public Integer getPostLikes() {
        return postLikes;
    }

    public void setPostLikes(Integer postLikes) {
        this.postLikes = postLikes;
    }

    public Integer getPostViews() {
        return postViews;
    }

    public void setPostViews(Integer postViews) {
        this.postViews = postViews;
    }

    public List<String> getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(List<String> photoUrl) {
        this.photoUrl = photoUrl;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}

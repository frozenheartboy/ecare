package com.ecare.web.vo;


import java.io.Serializable;
import java.util.List;

/**
 * Created by L on 2016/7/15.
 */
public class PostFormVo implements Serializable{
    private static final long serialVersionUID = 7031735888725773192L;
    private Integer postId;

    private String postTitle;

    private String postDesc;

    private Integer postUserId;

    private int postClassId;

    private Integer postLikes;

    private Integer postViews;

    private List<String> photoUrl;

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

    public String getPostDesc() {
        return postDesc;
    }

    public void setPostDesc(String postDesc) {
        this.postDesc = postDesc;
    }

    public Integer getPostUserId() {
        return postUserId;
    }

    public void setPostUserId(Integer postUserId) {
        this.postUserId = postUserId;
    }

    public int getPostClassId() {
        return postClassId;
    }

    public void setPostClassId(int postClassId) {
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
}

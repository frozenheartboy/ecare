package com.ecare.web.pojo;

import java.util.Date;

public class Post {
    private Integer postid;

    private String posttitle;

    private String postbody;

    private Date posttime;

    private Integer postuserid;

    private Integer postclassid;

    private Boolean postsort;

    private Integer postlike;

    public Integer getPostid() {
        return postid;
    }

    public void setPostid(Integer postid) {
        this.postid = postid;
    }

    public String getPosttitle() {
        return posttitle;
    }

    public void setPosttitle(String posttitle) {
        this.posttitle = posttitle == null ? null : posttitle.trim();
    }

    public String getPostbody() {
        return postbody;
    }

    public void setPostbody(String postbody) {
        this.postbody = postbody == null ? null : postbody.trim();
    }

    public Date getPosttime() {
        return posttime;
    }

    public void setPosttime(Date posttime) {
        this.posttime = posttime;
    }

    public Integer getPostuserid() {
        return postuserid;
    }

    public void setPostuserid(Integer postuserid) {
        this.postuserid = postuserid;
    }

    public Integer getPostclassid() {
        return postclassid;
    }

    public void setPostclassid(Integer postclassid) {
        this.postclassid = postclassid;
    }

    public Boolean getPostsort() {
        return postsort;
    }

    public void setPostsort(Boolean postsort) {
        this.postsort = postsort;
    }

    public Integer getPostlike() {
        return postlike;
    }

    public void setPostlike(Integer postlike) {
        this.postlike = postlike;
    }
}
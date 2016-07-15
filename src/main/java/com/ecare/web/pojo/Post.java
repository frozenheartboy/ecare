package com.ecare.web.pojo;

import java.util.Date;

public class Post {
    private Integer postid;

    private String posttitle;

    private String postbody;

    private Date posttime;

    private Date postedittime;

    private Integer postuserid;

    private Integer postclassid;

    private Boolean postsort;

    private Integer postlike;

    private Integer postviews;

    private String re1;

    private String re2;

    private String re3;

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

    public Date getPostedittime() {
        return postedittime;
    }

    public void setPostedittime(Date postedittime) {
        this.postedittime = postedittime;
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

    public Integer getPostviews() {
        return postviews;
    }

    public void setPostviews(Integer postviews) {
        this.postviews = postviews;
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
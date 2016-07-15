package com.ecare.web.pojo;

import java.io.Serializable;

public class Photo implements Serializable{

    private static final long serialVersionUID = -8370306089502450005L;

    private Integer photoId;

    private Integer photoPostId;

    private String photoUrl;

    private String re1;

    private String re2;

    private String re3;

    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    public Integer getPhotoPostId() {
        return photoPostId;
    }

    public void setPhotoPostId(Integer photoPostId) {
        this.photoPostId = photoPostId;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl == null ? null : photoUrl.trim();
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
package com.ecare.web.pojo;

import java.io.Serializable;

public class Likes implements Serializable{
    private static final long serialVersionUID = -8670173501140223354L;
    private Integer likesId;

    private Integer likesUserId;

    private Boolean likesType;

    private Integer likesTypeId;

    private String re1;

    private String re2;

    private String re3;

    public Integer getLikesId() {
        return likesId;
    }

    public void setLikesId(Integer likesId) {
        this.likesId = likesId;
    }

    public Integer getLikesUserId() {
        return likesUserId;
    }

    public void setLikesUserId(Integer likesUserId) {
        this.likesUserId = likesUserId;
    }

    public Boolean getLikesType() {
        return likesType;
    }

    public void setLikesType(Boolean likesType) {
        this.likesType = likesType;
    }

    public Integer getLikesTypeId() {
        return likesTypeId;
    }

    public void setLikesTypeId(Integer likesTypeId) {
        this.likesTypeId = likesTypeId;
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
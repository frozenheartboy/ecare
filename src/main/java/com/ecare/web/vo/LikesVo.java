package com.ecare.web.vo;

import java.io.Serializable;

/**
 * Created by L on 2016/7/18.
 */
public class LikesVo implements Serializable{
    private static final long serialVersionUID = 6322065870364143731L;
    private Integer likesId;

    private Integer likesUserId;

    private Boolean likesType;

    private Integer likesTypeId;

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
}

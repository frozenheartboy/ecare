package com.ecare.web.pojo;

import java.io.Serializable;

public class Favorite implements Serializable{

    private static final long serialVersionUID = -5043005590291035352L;

    private Integer favoriteId;

    private Integer favoriteUserId;

    private String favoritePostId;

    private String re1;

    private String re2;

    private String re3;

    public Integer getFavoriteId() {
        return favoriteId;
    }

    public void setFavoriteId(Integer favoriteId) {
        this.favoriteId = favoriteId;
    }

    public Integer getFavoriteUserId() {
        return favoriteUserId;
    }

    public void setFavoriteUserId(Integer favoriteUserId) {
        this.favoriteUserId = favoriteUserId;
    }

    public String getFavoritePostId() {
        return favoritePostId;
    }

    public void setFavoritePostId(String favoritePostId) {
        this.favoritePostId = favoritePostId == null ? null : favoritePostId.trim();
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
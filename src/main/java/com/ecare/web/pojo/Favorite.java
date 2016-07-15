package com.ecare.web.pojo;

public class Favorite {
    private Integer favoriteid;

    private Integer favoriteuserid;

    private String favoritepostid;

    private String re1;

    private String re2;

    private String re3;

    public Integer getFavoriteid() {
        return favoriteid;
    }

    public void setFavoriteid(Integer favoriteid) {
        this.favoriteid = favoriteid;
    }

    public Integer getFavoriteuserid() {
        return favoriteuserid;
    }

    public void setFavoriteuserid(Integer favoriteuserid) {
        this.favoriteuserid = favoriteuserid;
    }

    public String getFavoritepostid() {
        return favoritepostid;
    }

    public void setFavoritepostid(String favoritepostid) {
        this.favoritepostid = favoritepostid == null ? null : favoritepostid.trim();
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
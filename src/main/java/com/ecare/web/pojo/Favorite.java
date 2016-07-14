package com.ecare.web.pojo;

public class Favorite {
    private Integer favoriteid;

    private Integer favoriteuserid;

    private String favoritepostid;

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
}
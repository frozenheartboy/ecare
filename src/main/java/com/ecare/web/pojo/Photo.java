package com.ecare.web.pojo;

public class Photo {
    private Integer photoid;

    private Integer photopostid;

    private String photourl;

    private String re1;

    private String re2;

    private String re3;

    public Integer getPhotoid() {
        return photoid;
    }

    public void setPhotoid(Integer photoid) {
        this.photoid = photoid;
    }

    public Integer getPhotopostid() {
        return photopostid;
    }

    public void setPhotopostid(Integer photopostid) {
        this.photopostid = photopostid;
    }

    public String getPhotourl() {
        return photourl;
    }

    public void setPhotourl(String photourl) {
        this.photourl = photourl == null ? null : photourl.trim();
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
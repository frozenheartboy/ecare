package com.ecare.web.pojo;

public class Photo {
    private Integer photeid;

    private Integer photepostid;

    private String photourl;

    public Integer getPhoteid() {
        return photeid;
    }

    public void setPhoteid(Integer photeid) {
        this.photeid = photeid;
    }

    public Integer getPhotepostid() {
        return photepostid;
    }

    public void setPhotepostid(Integer photepostid) {
        this.photepostid = photepostid;
    }

    public String getPhotourl() {
        return photourl;
    }

    public void setPhotourl(String photourl) {
        this.photourl = photourl == null ? null : photourl.trim();
    }
}
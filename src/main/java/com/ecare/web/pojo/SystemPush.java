/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecare.web.pojo;

import java.util.Date;

/**
 * @author lpf
 * @datetime 2016-8-8 21:44:41
 * @email lipengfei19927@163.com
 */
public class SystemPush {

    private Integer id;
    private Integer user_id;
    private String info;
    private Integer cat;
    private Date addtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getCat() {
        return cat;
    }

    public void setCat(Integer cat) {
        this.cat = cat;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    @Override
    public String toString() {
        return "SystemPush{" + "id=" + id + ", user_id=" + user_id + ", info=" + info + ", cat=" + cat + ", addtime=" + addtime + '}';
    }
   
    
}

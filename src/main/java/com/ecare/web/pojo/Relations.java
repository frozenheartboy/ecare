package com.ecare.web.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 李鹏飞 lipengfei19927@163.com
 * @datetime 2016-8-3 9:15:18
 */
public class Relations implements Serializable {

    private Integer id;
    private Integer user_id;
    private Integer relation_id;
    private String relation_name;
    private Integer related_id;
    private Integer is_agree;
    private String relation_time;
    private Integer is_puppet;

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

    public Integer getRelation_id() {
        return relation_id;
    }

    public void setRelation_id(Integer relation_id) {
        this.relation_id = relation_id;
    }

    public String getRelation_name() {
        return relation_name;
    }

    public void setRelation_name(String relation_name) {
        this.relation_name = relation_name;
    }

    public Integer getRelated_id() {
        return related_id;
    }

    public void setRelated_id(Integer related_id) {
        this.related_id = related_id;
    }

    public Integer getIs_agree() {
        return is_agree;
    }

    public void setIs_agree(Integer is_agree) {
        this.is_agree = is_agree;
    }

    public String getRelation_time() {
        return relation_time;
    }

    public void setRelation_time(String relation_time) {
        this.relation_time = relation_time;
    }

    public Integer getIs_puppet() {
        return is_puppet;
    }

    public void setIs_puppet(Integer is_puppet) {
        this.is_puppet = is_puppet;
    }

    @Override
    public String toString() {
        return "Relations{" + "id=" + id + ", user_id=" + user_id + ", relation_id=" + relation_id + ", relation_name=" + relation_name + ", related_id=" + related_id + ", is_agree=" + is_agree + ", relation_time=" + relation_time + ", is_puppet=" + is_puppet + '}';
    }

 

}

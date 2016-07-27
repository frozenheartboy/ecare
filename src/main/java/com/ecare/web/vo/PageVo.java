package com.ecare.web.vo;

import java.io.Serializable;

/**
 * Created by L on 2016/7/14.
 */
public class PageVo implements Serializable{

    private static final long serialVersionUID = -8212495011954051624L;
    private int pageStart;
    private int pageSize;

    public Integer getPageStart() {
        return pageStart;
    }

    public void setPageStart(Integer pageStart) {
        this.pageStart = pageStart;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }



}

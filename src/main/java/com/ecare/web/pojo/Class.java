package com.ecare.web.pojo;

public class Class {
    private Integer classid;

    private String classname;

    private String re1;

    private String re2;

    private String re3;

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
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
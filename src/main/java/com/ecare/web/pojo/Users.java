package com.ecare.web.pojo;

import java.io.Serializable;
import java.util.Date;

public class Users implements Serializable {

    private static final long serialVersionUID = 6420929286290072402L;

    private Integer id;

    private String phone;

    private String password;

    private Date logintime;

    private Date regtime;

    private String name;

    private String nickname;

    private String sex;

    private Integer age;

    private Double height;

    private Double weight;

    private Double waistline;

    private String education;

    private String email;

    private String headUrl;

    private String city;

    private Double bmi;

    private String diseasesIds;

    private Integer membership;

    private String jobId;

    private String painLocationId;

    private Boolean tfHistory;

    private Boolean tfJxgjy;

    private Byte nowVas;

    private Byte lastVas;

    private String sua;

    private Boolean isOpenClock;

    private Date diseaseLastUpdatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getLogintime() {
        return logintime;
    }

    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }

    public Date getRegtime() {
        return regtime;
    }

    public void setRegtime(Date regtime) {
        this.regtime = regtime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getWaistline() {
        return waistline;
    }

    public void setWaistline(Double waistline) {
        this.waistline = waistline;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl == null ? null : headUrl.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public Double getBmi() {
        return bmi;
    }

    public void setBmi(Double bmi) {
        this.bmi = bmi;
    }

    public String getDiseasesIds() {
        return diseasesIds;
    }

    public void setDiseasesIds(String diseasesIds) {
        this.diseasesIds = diseasesIds == null ? null : diseasesIds.trim();
    }

    public Integer getMembership() {
        return membership;
    }

    public void setMembership(Integer membership) {
        this.membership = membership;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId == null ? null : jobId.trim();
    }

    public String getPainLocationId() {
        return painLocationId;
    }

    public void setPainLocationId(String painLocationId) {
        this.painLocationId = painLocationId == null ? null : painLocationId.trim();
    }

    public Boolean getTfHistory() {
        return tfHistory;
    }

    public void setTfHistory(Boolean tfHistory) {
        this.tfHistory = tfHistory;
    }

    public Boolean getTfJxgjy() {
        return tfJxgjy;
    }

    public void setTfJxgjy(Boolean tfJxgjy) {
        this.tfJxgjy = tfJxgjy;
    }

    public Byte getNowVas() {
        return nowVas;
    }

    public void setNowVas(Byte nowVas) {
        this.nowVas = nowVas;
    }

    public Byte getLastVas() {
        return lastVas;
    }

    public void setLastVas(Byte lastVas) {
        this.lastVas = lastVas;
    }

    public String getSua() {
        return sua;
    }

    public void setSua(String sua) {
        this.sua = sua == null ? null : sua.trim();
    }

    public Boolean getIsOpenClock() {
        return isOpenClock;
    }

    public void setIsOpenClock(Boolean isOpenClock) {
        this.isOpenClock = isOpenClock;
    }

    public Date getDiseaseLastUpdatetime() {
        return diseaseLastUpdatetime;
    }

    public void setDiseaseLastUpdatetime(Date diseaseLastUpdatetime) {
        this.diseaseLastUpdatetime = diseaseLastUpdatetime;
    }
}
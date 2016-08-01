package com.ecare.web.pojo;

import java.io.Serializable;
import java.util.Date;

public class OpUserMedicineRecords implements Serializable{
    private static final long serialVersionUID = 4154242220489104726L;
    private Integer id;

    private Integer userId;

    private String codeid;

    private String recordName;

    private String recordValue;

    private Date recordTime;

    private Integer treatmentPeriod;

    private String remindTime;

    private String takingFrequency;

    private String takingWays;

    private Date startTime;

    private Boolean isOutTime;

    private Byte isOpenClock;

    private Short cat;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCodeid() {
        return codeid;
    }

    public void setCodeid(String codeid) {
        this.codeid = codeid == null ? null : codeid.trim();
    }

    public String getRecordName() {
        return recordName;
    }

    public void setRecordName(String recordName) {
        this.recordName = recordName == null ? null : recordName.trim();
    }

    public String getRecordValue() {
        return recordValue;
    }

    public void setRecordValue(String recordValue) {
        this.recordValue = recordValue == null ? null : recordValue.trim();
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public Integer getTreatmentPeriod() {
        return treatmentPeriod;
    }

    public void setTreatmentPeriod(Integer treatmentPeriod) {
        this.treatmentPeriod = treatmentPeriod;
    }

    public String getRemindTime() {
        return remindTime;
    }

    public void setRemindTime(String remindTime) {
        this.remindTime = remindTime == null ? null : remindTime.trim();
    }

    public String getTakingFrequency() {
        return takingFrequency;
    }

    public void setTakingFrequency(String takingFrequency) {
        this.takingFrequency = takingFrequency == null ? null : takingFrequency.trim();
    }

    public String getTakingWays() {
        return takingWays;
    }

    public void setTakingWays(String takingWays) {
        this.takingWays = takingWays == null ? null : takingWays.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Boolean getIsOutTime() {
        return isOutTime;
    }

    public void setIsOutTime(Boolean isOutTime) {
        this.isOutTime = isOutTime;
    }

    public Byte getIsOpenClock() {
        return isOpenClock;
    }

    public void setIsOpenClock(Byte isOpenClock) {
        this.isOpenClock = isOpenClock;
    }

    public Short getCat() {
        return cat;
    }

    public void setCat(Short cat) {
        this.cat = cat;
    }
}
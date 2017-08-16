package com.mcylm.cley.service.userservice.entity;

import java.io.Serializable;
import java.util.Date;

public class UcenterD {
    private Integer id;
    private String uuid;
    private String cn_name;
    private String en_name;
    private Date birthday;
    private String sex;
    private String job;
    private String education;
    private String school;
    private String locationId;
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCn_name() {
        return cn_name;
    }

    public void setCn_name(String cn_name) {
        this.cn_name = cn_name;
    }

    public String getEn_name() {
        return en_name;
    }

    public void setEn_name(String en_name) {
        this.en_name = en_name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "UcenterD{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", cn_name='" + cn_name + '\'' +
                ", en_name='" + en_name + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", job='" + job + '\'' +
                ", education='" + education + '\'' +
                ", school='" + school + '\'' +
                ", locationId='" + locationId + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}

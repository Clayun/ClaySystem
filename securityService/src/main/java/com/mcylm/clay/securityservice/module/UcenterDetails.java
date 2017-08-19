package com.mcylm.clay.securityservice.module;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author:Wuyali
 * @Description:
 * @Date:Created in 8:33 2017/8/16
 * @Modified By:
 */
//户中心细节
public class UcenterDetails implements Serializable{

    private Integer id;
    private String uuid;
    private String cn_Name;
    private String en_Name;
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

    public String getCn_Name() {
        return cn_Name;
    }

    public void setCn_Name(String cn_Name) {
        this.cn_Name = cn_Name;
    }

    public String getEn_Name() {
        return en_Name;
    }

    public void setEn_Name(String en_Name) {
        this.en_Name = en_Name;
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
}

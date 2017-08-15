package com.mcylm.clay.service.paymentservice.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 活动优惠
 */
public class ActivityDetails implements Serializable {
    private Integer id;
    private String type;       //活动类型，如百分比降价，直降价等
    private String title;     //活动标题
    private String abstractInfo; //活动概述
    private String content;    //活动详情
    private String num;        //对应Type的具体参数
    private Date startTime;   //起始日期
    private Date overTime;    //截止日期
    private String managerName; //负责人名称
    private String state;     //活动状态，0为未开始，1为进行中，2为已结束
    private String selected;

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstractInfo() {
        return abstractInfo;
    }

    public void setAbstractInfo(String abstractInfo) {
        this.abstractInfo = abstractInfo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getOverTime() {
        return overTime;
    }

    public void setOverTime(Date overTime) {
        this.overTime = overTime;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "ActivityDetails{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", abstractInfo='" + abstractInfo + '\'' +
                ", content='" + content + '\'' +
                ", num='" + num + '\'' +
                ", startTime=" + startTime +
                ", overTime=" + overTime +
                ", managerName='" + managerName + '\'' +
                ", state='" + state + '\'' +
                ", selected=" + selected +
                '}';
    }
}

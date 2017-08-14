package com.mcylm.clay.service.consoleservice.model;

import java.util.Date;

/**
 * Created by macbook on 2017/8/11.
 */
public class ActivitiesStr {
    private Integer id;
    private String type;
    private String title;
    private String abstractInfo;
    private String content;
    private String num;
    private String startTime;
    private String overTime;
    private String managerName;
    private String state;
    private String selected;
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getOverTime() {
        return overTime;
    }

    public void setOverTime(String overTime) {
        this.overTime = overTime;
    }

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
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
        return "ActivitiesStr{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", abstractInfo='" + abstractInfo + '\'' +
                ", content='" + content + '\'' +
                ", num='" + num + '\'' +
                ", startTime='" + startTime + '\'' +
                ", overTime='" + overTime + '\'' +
                ", managerName='" + managerName + '\'' +
                ", state='" + state + '\'' +
                ", selected='" + selected + '\'' +
                '}';
    }
}

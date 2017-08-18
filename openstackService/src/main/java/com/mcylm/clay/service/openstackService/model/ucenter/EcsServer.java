package com.mcylm.clay.service.openstackService.model.ucenter;

import java.util.Date;

/**
 * Created by Mikesam on 2017/8/15.
 */
public class EcsServer {

    private int id;
    private String uuid;
    private String ser_uuid;
    private String ser_name;
    private String cpu;
    private String memory;
    private String os_disk;
    private String expand_disk;
    private String tape;
    private String ips;
    private String image;
    private String password;
    private String days;
    private String pricePerMonth;
    private String state;
    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getSer_uuid() {
        return ser_uuid;
    }

    public void setSer_uuid(String ser_uuid) {
        this.ser_uuid = ser_uuid;
    }

    public String getSer_name() {
        return ser_name;
    }

    public void setSer_name(String ser_name) {
        this.ser_name = ser_name;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getOs_disk() {
        return os_disk;
    }

    public void setOs_disk(String os_disk) {
        this.os_disk = os_disk;
    }

    public String getExpand_disk() {
        return expand_disk;
    }

    public void setExpand_disk(String expand_disk) {
        this.expand_disk = expand_disk;
    }

    public String getTape() {
        return tape;
    }

    public void setTape(String tape) {
        this.tape = tape;
    }

    public String getIps() {
        return ips;
    }

    public void setIps(String ips) {
        this.ips = ips;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getPricePerMonth() {
        return pricePerMonth;
    }

    public void setPricePerMonth(String pricePerMonth) {
        this.pricePerMonth = pricePerMonth;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "EcsServer{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", ser_uuid='" + ser_uuid + '\'' +
                ", ser_name='" + ser_name + '\'' +
                ", cpu='" + cpu + '\'' +
                ", memory='" + memory + '\'' +
                ", os_disk='" + os_disk + '\'' +
                ", expand_disk='" + expand_disk + '\'' +
                ", tape='" + tape + '\'' +
                ", ips='" + ips + '\'' +
                ", image='" + image + '\'' +
                ", password='" + password + '\'' +
                ", days='" + days + '\'' +
                ", pricePerMonth='" + pricePerMonth + '\'' +
                ", state='" + state + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}

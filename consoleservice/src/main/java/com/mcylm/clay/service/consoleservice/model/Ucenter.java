package com.mcylm.clay.service.consoleservice.model;

import java.util.Date;

/**
 * Created by macbook on 2017/8/7.
 */
public class Ucenter {
    /*
    * 作者:邢子琛
    * */
    private Integer id;
    private String uuid;
    private String username;
    private String phone;
    private String password;
    private Date createTime;
    private String permission;
    private String bindUser;

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
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPermission() {
        return permission;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public void setPermission(String permission) {
        this.permission = permission;
    }
    public String getBindUser() {
        return bindUser;
    }
    public void setBindUser(String bindUser) {
        this.bindUser = bindUser;
    }
}

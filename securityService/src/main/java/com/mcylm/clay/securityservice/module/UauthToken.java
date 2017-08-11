package com.mcylm.clay.securityservice.module;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息表
 * Created by lenovo on 2017/8/9.
 */
public class UauthToken implements Serializable{
    private Integer id;
    private String uuid;
    private String clientid;
    private Date logintime;
    private String token;
    private String hostip;

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

    public String getClientid() {
        return clientid;
    }

    public void setClientid(String clientid) {
        this.clientid = clientid;
    }

    public Date getLogintime() {
        return logintime;
    }

    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getHostip() {
        return hostip;
    }

    public void setHostip(String hostip) {
        this.hostip = hostip;
    }
}

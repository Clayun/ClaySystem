package com.mcylm.clay.service.consoleservice.model;

import java.util.Date;

/**
 * @Author:Mr_Shen
 * @Description: - -!
 * @Date:2017/8/17/017
 * @Modified By:None one
 */
public class Token {

    private Integer id;
    private String uuid;
    private String clientid;
    private String token;
    private Date logintime;
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
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public Date getLogintime() {
        return logintime;
    }
    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }
    public String getHostip() {
        return hostip;
    }
    public void setHostip(String hostip) {
        this.hostip = hostip;
    }
}

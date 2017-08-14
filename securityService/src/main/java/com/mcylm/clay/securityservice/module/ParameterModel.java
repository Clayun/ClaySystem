package com.mcylm.clay.securityservice.module;

/**
 * Created by lenovo on 2017/8/11.
 * 接入的参数及信息模型
 */
public class ParameterModel {
    private String redirectUrl;
    private String username;
    private String password;
    private String status;
    private String token;
    private String loginType;
    private String fmlName;

    public String getFmlName() {
        return fmlName;
    }

    public void setFmlName(String fmlName) {
        this.fmlName = fmlName;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

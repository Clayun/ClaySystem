package com.mcylm.clay.securityservice.module;

import java.io.Serializable;

/**
 * @Author:Wuyali
 * @Description:
 * @Date:Created in 8:31 2017/8/16
 * @Modified By:
 */
//户中心
public class Ucenter implements Serializable {

    private Integer id;
    private String uuid;
    private String avatar;
    private String level;
    private String exp;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

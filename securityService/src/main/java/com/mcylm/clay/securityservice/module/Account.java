package com.mcylm.clay.securityservice.module;

import java.io.Serializable;

/**
 * @Author:Wuyali
 * @Description:
 * @Date:Created in 8:32 2017/8/16
 * @Modified By:
 */
//账户
public class Account implements Serializable {
    private Integer id;
    private String uuid;
    private String money;
    private String score;
    private String consume;

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

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getConsume() {
        return consume;
    }

    public void setConsume(String consume) {
        this.consume = consume;
    }
}

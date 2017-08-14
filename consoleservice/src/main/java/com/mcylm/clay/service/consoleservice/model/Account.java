package com.mcylm.clay.service.consoleservice.model;

/**
 * @Author:Mr_Shen
 * @Description: - -!
 * @Date:2017/8/14/014
 * @Modified By:None one
 */
public class Account {
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

package com.mcylm.clay.service.paymentservice.model;

import java.io.Serializable;

/**
 * 等级信息
 * Created by lenovo-pc on 2017/8/11.
 */
public class Account implements Serializable {
    private Integer id;
    private String uuid;    //用户的UUID
    private String money;  //余额
    private String score;   //积分
    private String consume; //累计消费

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", money='" + money + '\'' +
                ", score='" + score + '\'' +
                ", consume='" + consume + '\'' +
                '}';
    }

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

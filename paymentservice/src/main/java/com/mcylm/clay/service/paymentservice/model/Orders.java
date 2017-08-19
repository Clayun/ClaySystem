package com.mcylm.clay.service.paymentservice.model;

import sun.plugin2.message.Serializer;

import java.io.Serializable;
import java.security.PrivateKey;
import java.util.Date;

/**
 * Created by lenovo-pc on 2017/8/7.A
 */
public class Orders implements Serializable{
    private Integer id;
    private String OrdersUuid;
    private String uuid;
    private Integer amount;
    private Integer paymentPurposes;
    private String remarks;
    private Date paymentTime;
    private Integer theActualAmount;
    private Integer state;
    private String month;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrdersUuid() {
        return OrdersUuid;
    }

    public void setOrdersUuid(String ordersUuid) {
        OrdersUuid = ordersUuid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getPaymentPurposes() {
        return paymentPurposes;
    }

    public void setPaymentPurposes(Integer paymentPurposes) {
        this.paymentPurposes = paymentPurposes;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Integer getTheActualAmount() {
        return theActualAmount;
    }

    public void setTheActualAmount(Integer theActualAmount) {
        this.theActualAmount = theActualAmount;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", OrdersUuid='" + OrdersUuid + '\'' +
                ", uuid='" + uuid + '\'' +
                ", amount=" + amount +
                ", paymentPurposes=" + paymentPurposes +
                ", remarks='" + remarks + '\'' +
                ", paymentTime=" + paymentTime +
                ", theActualAmount=" + theActualAmount +
                ", state=" + state +
                ", month='" + month + '\'' +
                '}';
    }
}

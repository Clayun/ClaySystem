package com.mcylm.cley.service.userservice.entity;

import java.util.Date;

public class ComOrder {
    private Integer id;
    private String ordersUuid;
    private String uuid;
    private Integer amount;
    private Integer paymentPurposes;
    private String remarks;
    private Date paymentTime;
    private Integer theActualAmout;
    private Integer state;
    private String month;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrdersUuid() {
        return ordersUuid;
    }

    public void setOrdersUuid(String ordersUuid) {
        this.ordersUuid = ordersUuid;
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

    public Integer getTheActualAmout() {
        return theActualAmout;
    }

    public void setTheActualAmout(Integer theActualAmout) {
        this.theActualAmout = theActualAmout;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "ComOrder{" +
                "id=" + id +
                ", ordersUuid='" + ordersUuid + '\'' +
                ", uuid='" + uuid + '\'' +
                ", amount=" + amount +
                ", paymentPurposes=" + paymentPurposes +
                ", remarks='" + remarks + '\'' +
                ", paymentTime=" + paymentTime +
                ", theActualAmout=" + theActualAmout +
                ", state=" + state +
                ", month='" + month + '\'' +
                '}';
    }
}

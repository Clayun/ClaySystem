package com.mcylm.clay.service.consoleservice.model;

import java.util.Date;

/**
 * @Author:Mr_Shen
 * @Description: - -!
 * @Date:2017/8/15/015
 * @Modified By:None one
 */
public class Orders {

    private Integer id;
    private String ordersUuid;
    private String uuid;
    private Integer amount;
    private Integer payid;
    private String payName;
    private String remarks;
    private Date paymentTime;
    private Integer theActualAmount;
    private Integer stateId;
    private String stateName;
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
    public Integer getPayid() {
        return payid;
    }
    public void setPayid(Integer payid) {
        this.payid = payid;
    }
    public String getPayName() {
        return payName;
    }
    public void setPayName(String payName) {
        this.payName = payName;
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
    public Integer getStateId() {
        return stateId;
    }
    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }
    public String getStateName() {
        return stateName;
    }
    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
    public String getMonth() {
        return month;
    }
    public void setMonth(String month) {
        this.month = month;
    }
}

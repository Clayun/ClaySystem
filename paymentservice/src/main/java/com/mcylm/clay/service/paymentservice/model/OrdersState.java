package com.mcylm.clay.service.paymentservice.model;




/**
 * Created by lenovo-pc on 2017/8/8.
 */
public class OrdersState {
    private Integer stateId;
    private String stateName;

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

    @Override
    public String toString() {
        return "OrdersState{" +
                "stateId=" + stateId +
                ", stateName=" + stateName +
                '}';
    }
}

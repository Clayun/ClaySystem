package com.mcylm.clay.service.paymentservice.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单详细
 * Created by lenovo-pc on 2017/8/10.
 */
public class OrdersDetails implements Serializable{
    private Integer id;
    private Integer ordersId; //外键Orders
    private  String content;  //购买详情参数
    private Double length;    //购买时长
    private Integer activityId;////外键activityDetails
    private Date createTime; //创建时间

    @Override
    public String toString() {
        return "OrdersDetails{" +
                "id=" + id +
                ", ordersId=" + ordersId +
                ", content='" + content + '\'' +
                ", length=" + length +
                ", activityId=" + activityId +
                ", createTime=" + createTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(Integer ordersId) {
        this.ordersId = ordersId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}

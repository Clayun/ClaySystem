package com.mcylm.clay.service.paymentservice.dao;

import com.mcylm.clay.service.paymentservice.model.Orders;

import java.util.List;

/**
 * Created by lenovo-pc on 2017/8/7.
 */
public interface OrdersDao {
    //支付
    int paymentInterface(Integer theActualAmount, Integer score,String uuid);

    List<Orders> paymentInterfaceList();

    Integer paymentInterfaceAdd(Orders orders);
}

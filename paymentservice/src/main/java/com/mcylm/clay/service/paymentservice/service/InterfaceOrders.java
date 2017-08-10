package com.mcylm.clay.service.paymentservice.service;

import com.mcylm.clay.service.paymentservice.model.Orders;

import java.util.List;

/**
 * Created by lenovo-pc on 2017/8/7.
 */
public interface InterfaceOrders {
    //支付
    int paymentInterface(Orders orders);

    List<Orders> paymentInterfaceList();

    int withdrawalInterface(Orders orders);

    int rechargeInterface(Orders orders);
}

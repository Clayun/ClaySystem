package com.mcylm.clay.service.paymentservice.dao.impl;

import com.mcylm.clay.service.paymentservice.dao.OrdersDao;
import com.mcylm.clay.service.paymentservice.mapper.OrdersMapper;
import com.mcylm.clay.service.paymentservice.model.Orders;
import com.mcylm.clay.service.paymentservice.model.OrdersState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo-pc on 2017/8/7.
 */
@Repository
public class OrdersDaoImpl implements OrdersDao {

    @Autowired
    private OrdersMapper ordersMapper;

    //支付
    @Override
    public int paymentInterface(Integer theActualAmount,Integer score,String uuid) {
        return ordersMapper.paymentInterface(theActualAmount,score,uuid);
}

    @Override
    public List<Orders> paymentInterfaceList() {
        List<Orders> ordersList = ordersMapper.paymentInterfaceList();
        for (Orders orders : ordersList) {
            OrdersState state = ordersMapper.getStateNameById(orders.getState());
            OrdersState paymentPurpose = ordersMapper.getStateNameById(orders.getPaymentPurposes());
            orders.setStatesName(state.getStateName());
            orders.setPaymentPurposesName(paymentPurpose.getStateName());
        }
        return ordersList;
    }

    @Override
    public Integer paymentInterfaceAdd(Orders orders) {
        return ordersMapper.paymentInterfaceAdd(orders);
    }
}

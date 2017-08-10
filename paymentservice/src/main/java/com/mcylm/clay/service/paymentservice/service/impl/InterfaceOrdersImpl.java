package com.mcylm.clay.service.paymentservice.service.impl;

import com.mcylm.clay.service.paymentservice.dao.OrdersDao;
import com.mcylm.clay.service.paymentservice.model.Orders;
import com.mcylm.clay.service.paymentservice.service.InterfaceOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo-pc on 2017/8/7.
 */
@Service
public class InterfaceOrdersImpl implements InterfaceOrders {

    @Autowired
    private OrdersDao ordersDao;

    @Override
    public int paymentInterface(Orders orders) {
        Integer score = Integer.valueOf((orders.getTheActualAmount()/10));
        int i = ordersDao.paymentInterface(orders.getTheActualAmount(), score, orders.getUuid());
        /*if(i>0){
            int j = ordersDao.paymentInterfaceInfo(orders);
            return j;
        }*/
        return i;
    }

    @Override
    public List<Orders> paymentInterfaceList() {
        return ordersDao.paymentInterfaceList();
    }

    @Override
    public int withdrawalInterface(Orders orders) {
        return 0;
    }

    @Override
    public int rechargeInterface(Orders orders) {
        return 0;
    }

}

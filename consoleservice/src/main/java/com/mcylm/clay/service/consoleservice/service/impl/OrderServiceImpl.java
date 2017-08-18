package com.mcylm.clay.service.consoleservice.service.impl;

import com.mcylm.clay.service.consoleservice.dao.OrderDao;
import com.mcylm.clay.service.consoleservice.model.Dateils;
import com.mcylm.clay.service.consoleservice.model.Orders;
import com.mcylm.clay.service.consoleservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:Mr_Shen
 * @Description: - -!
 * @Date:2017/8/15/015
 * @Modified By:None one
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;


    @Override
    public List<Orders> getOrderList() {
        List<Orders> list=orderDao.getOrderList();
        return list;
    }

    @Override
    public Dateils ordersSelect(String ordersUuid) {
        Dateils dateils=orderDao.ordersSelect(ordersUuid);
        return dateils;
    }
}

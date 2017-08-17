package com.mcylm.clay.service.consoleservice.dao.impl;

import com.mcylm.clay.service.consoleservice.dao.OrderDao;
import com.mcylm.clay.service.consoleservice.mapper.OrderMapper;
import com.mcylm.clay.service.consoleservice.model.Dateils;
import com.mcylm.clay.service.consoleservice.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:Mr_Shen
 * @Description: - -!
 * @Date:2017/8/15/015
 * @Modified By:None one
 */
@Repository
public class OrderDaoImpl  implements OrderDao {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Orders> getOrderList() {
        List<Orders> list=orderMapper.getOrderList();
        return list;
    }

    @Override
    public Dateils ordersSelect(String ordersUuid) {
        Dateils dateils=orderMapper.ordersSelect(ordersUuid);
        return dateils;
    }
}

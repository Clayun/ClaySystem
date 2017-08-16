package com.mcylm.clay.service.paymentservice.dao.impl;

import com.mcylm.clay.service.paymentservice.dao.OrdersDao;
import com.mcylm.clay.service.paymentservice.mapper.OrdersMapper;
import com.mcylm.clay.service.paymentservice.model.Account;
import com.mcylm.clay.service.paymentservice.model.ActivityDetails;
import com.mcylm.clay.service.paymentservice.model.Orders;
import org.apache.ibatis.annotations.Param;
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

    @Override
    public Orders getOrdersByUuid(String uuid, String ordersUuid) {
        return ordersMapper.getOrdersByUuid(uuid, ordersUuid);
    }

    //查询活动
    @Override
    public List<ActivityDetails> getDetails() {
        return ordersMapper.getDetails();
    }

    //计算优惠后的价格
    @Override
    public ActivityDetails getDetailsById(Integer id) {
        return ordersMapper.getDetailsById(id);
    }

    //查询活动
    @Override
    public List<ActivityDetails> getDetailsSelected() {
        return ordersMapper.getDetailsSelected();
    }

    @Override
    public ActivityDetails getDetailsBySelectId(String selectedId) {
        return ordersMapper.getDetailsById(Integer.valueOf(selectedId));
    }

    //计算优惠后的价格


    //信息添加
    @Override
    public Integer paymentInterfaceAdd(Orders orders) {
        return ordersMapper.paymentInterfaceAdd(orders);
    }

    //详细信息添加
    @Override
    public Integer paymentInterfaceOrdersDetails(Orders orders) {
        String content = "" + orders.getUuid() + "-" + orders.getAmount() + "-" + orders.getPaymentPurposes() + "-" + orders.getRemarks() + "-" + orders.getTheActualAmount();
        Integer activityId = 1;
        Integer length = Integer.valueOf(orders.getMonth()) * 31;
        return ordersMapper.paymentInterfaceOrdersDetails(Integer.valueOf(orders.getUuid()), content, length, activityId);
    }

    //查询余额
    @Override
    public Account getMoneyByAccountUuid(@Param("uuid") String uuid) {
        return ordersMapper.getMoneyByAccountUuid(uuid);
    }

    //支付
    @Override
    public Integer paymentInterface(Integer theActualAmount, Integer score, String uuid) {
        return ordersMapper.paymentInterface(theActualAmount, score, uuid);
    }

    // 修改状态
    @Override
    public Integer paymentInterfaceOrders(@Param("ordersUuid") String ordersUuid, @Param("uuid") String uuid, @Param("state") int state) {
        return ordersMapper.paymentInterfaceOrders(ordersUuid, uuid, state);
    }
}

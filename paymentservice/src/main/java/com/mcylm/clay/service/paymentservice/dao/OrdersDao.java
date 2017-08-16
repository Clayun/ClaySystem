package com.mcylm.clay.service.paymentservice.dao;

import com.mcylm.clay.service.paymentservice.model.Account;
import com.mcylm.clay.service.paymentservice.model.ActivityDetails;
import com.mcylm.clay.service.paymentservice.model.Orders;

import java.util.List;

/**
 * Created by lenovo-pc on 2017/8/7.
 */
public interface OrdersDao {
    //信息添加
    Integer paymentInterfaceAdd(Orders orders);

    //详细信息添加
    Integer paymentInterfaceOrdersDetails(Orders orders);

    //支付
    Integer paymentInterface(Integer theActualAmount, Integer score, String uuid);

    //查询余额
    Account getMoneyByAccountUuid(String uuid);

    //修改状态
    Integer paymentInterfaceOrders(String ordersUuid, String uuid, int i);

    //回显
    Orders getOrdersByUuid(String uuid, String ordersUuid);

    //查询活动
    List<ActivityDetails> getDetails();

    //查询活动
    List<ActivityDetails> getDetailsSelected();

    //计算优惠后的价格
    ActivityDetails getDetailsById(Integer integer);

    //计算优惠后的价格
    ActivityDetails getDetailsBySelectId(String selectedId);
}

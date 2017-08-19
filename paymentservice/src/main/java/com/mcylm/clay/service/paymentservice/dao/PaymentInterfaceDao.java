package com.mcylm.clay.service.paymentservice.dao;

import com.mcylm.clay.service.paymentservice.model.*;

import java.util.List;

/**
 * Created by lenovo-pc on 2017/8/7.
 */
public interface PaymentInterfaceDao {
    //信息添加
    Integer paymentInterfaceAdd(Orders orders);

    //详细信息添加
    Integer paymentInterfaceOrdersDetails(EcsServer ecsServer, String ordersUuid);

    //支付
    Integer paymentInterface(Double theActualAmount, Integer score, String uuid);

    //查询余额
    Account getMoneyByAccountUuid(String uuid);

    //修改状态
    Integer paymentInterfaceOrders(String ordersUuid, String uuid, int i);

    //查询活动
    List<ActivityDetails> getDetails();

    //查询活动
    List<ActivityDetails> getDetailsSelected();

    //计算优惠后的价格
    ActivityDetails getDetailsById(Integer integer);

    //计算优惠后的价格
    ActivityDetails getDetailsBySelectId(String selectedId);

    //添加服务器表
    Integer paymentInterfaceEcsServer(EcsServer ecsServer);

    //修改orders
    Integer updateOrders(String ordersUuid, String uuid, Double theActualAmount, Integer month, Double pricePerMonth);

    //补充ordersDetails
    Integer updateOrdersDetails(String ordersUuid, Integer month, String check_val);

    //修改服务
    Integer updateEcsServer(String uuid, String ser_uuid);

    //查手机号
    Uauth getUserPhone(String uuid);
}

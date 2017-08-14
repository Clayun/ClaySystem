package com.mcylm.clay.service.paymentservice.service;

import com.mcylm.clay.service.paymentservice.model.ActivityDetails;
import com.mcylm.clay.service.paymentservice.model.Orders;

import java.util.List;

/**
 * Created by lenovo-pc on 2017/8/7.
 */
public interface InterfaceOrders {

    //添加信息
    Orders paymentInterfaceAdd(String data);

    //支付
    Integer paymentInterface(String ordersUuid, String uuid, Integer theActualAmount);

    /*//查询回显
    Orders getOrdersByUuid(String uuid);*/

    int withdrawalInterface(Orders orders);

    int rechargeInterface(Orders orders);

    //查询活动
    List<ActivityDetails> getDetails();

    //计算活动 价钱 单选
    //Double getDetailsById(String id,Integer month,Integer entityPrice);
    Double getDetailsById(Integer month, Integer entityPrice, String check_val, Integer id);

    //计算活动 价钱 多选
    List<ActivityDetails> getDetailsSelected();


}

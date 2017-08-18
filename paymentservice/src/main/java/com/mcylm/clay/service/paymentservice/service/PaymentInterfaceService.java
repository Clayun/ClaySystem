package com.mcylm.clay.service.paymentservice.service;

import com.mcylm.clay.service.paymentservice.model.ActivityDetails;
import com.mcylm.clay.service.paymentservice.model.EcsServer;
import com.mcylm.clay.service.paymentservice.model.Orders;
import com.mcylm.clay.service.paymentservice.model.Uauth;

import java.util.List;

/**
 * Created by lenovo-pc on 2017/8/7.
 */
public interface PaymentInterfaceService {

    //添加信息
    Integer paymentInterfaceAdd(String date);

    //支付
    Integer paymentInterface(String ordersUuid, String uuids, Double theActualAmount, Integer month, Double pricePerMonth, String check_val, Integer id, String ser_uuid);

    //查询活动
    List<ActivityDetails> getDetails();

    //计算活动 价钱 单选
    Double getDetailsById(Integer month, Double entityPrice, String check_val, Integer id);

    //计算活动 价钱 多选
    List<ActivityDetails> getDetailsSelected();

    //查手机号
    Uauth getUserPhone(String uuid);
}

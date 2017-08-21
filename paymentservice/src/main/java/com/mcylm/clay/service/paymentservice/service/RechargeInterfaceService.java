package com.mcylm.clay.service.paymentservice.service;

/**
 * Created by lenovo-pc on 2017/8/17.
 */
public interface RechargeInterfaceService {
    //充值
    Integer rechargeInterface(String uuid, Double amount, String r6_Order);
}

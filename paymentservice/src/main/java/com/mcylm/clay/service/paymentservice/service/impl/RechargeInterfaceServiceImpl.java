package com.mcylm.clay.service.paymentservice.service.impl;

import com.mcylm.clay.service.paymentservice.dao.RechargeInterfaceDao;
import com.mcylm.clay.service.paymentservice.service.RechargeInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lenovo-pc on 2017/8/17.
 */
@Service
public class RechargeInterfaceServiceImpl implements RechargeInterfaceService{
   @Autowired
    private RechargeInterfaceDao rechargeInterfaceDao;

   //充值
    @Override
    public Integer rechargeInterface(String uuid, Double amount, String r6_Order) {
        Double money=0.0;

        return rechargeInterfaceDao.rechargeInterface(uuid,amount,r6_Order);
    }
}

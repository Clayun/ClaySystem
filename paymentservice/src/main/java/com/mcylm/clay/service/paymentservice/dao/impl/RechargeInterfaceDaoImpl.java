package com.mcylm.clay.service.paymentservice.dao.impl;

import com.mcylm.clay.service.paymentservice.dao.RechargeInterfaceDao;
import com.mcylm.clay.service.paymentservice.mapper.RechargeInterfaceMapper;
import com.mcylm.clay.service.paymentservice.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lenovo-pc on 2017/8/17.
 */
@Repository
public class RechargeInterfaceDaoImpl implements RechargeInterfaceDao {
    @Autowired
    private RechargeInterfaceMapper rechargeInterfaceMapper;

    //充值

    @Override
    public Integer rechargeInterface(String uuid, Double amount,String r6_Order) {

        Integer i = rechargeInterfaceMapper.rechargeInterface(uuid, amount,r6_Order);

        return i==0?0:rechargeInterfaceMapper.addAccount(uuid,amount);
    }
}

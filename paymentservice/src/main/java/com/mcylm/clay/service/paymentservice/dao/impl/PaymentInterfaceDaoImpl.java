package com.mcylm.clay.service.paymentservice.dao.impl;

import com.mcylm.clay.service.paymentservice.dao.PaymentInterfaceDao;
import com.mcylm.clay.service.paymentservice.mapper.PaymentInterfaceMapper;
import com.mcylm.clay.service.paymentservice.model.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo-pc on 2017/8/7.
 */
@Repository
public class PaymentInterfaceDaoImpl implements PaymentInterfaceDao {

    @Autowired
    private PaymentInterfaceMapper paymentInterfaceMapper;


    //查询活动
    @Override
    public List<ActivityDetails> getDetails() {
        return paymentInterfaceMapper.getDetails();
    }

    //计算优惠后的价格
    @Override
    public ActivityDetails getDetailsById(Integer id) {
        return paymentInterfaceMapper.getDetailsById(id);
    }

    //查询活动
    @Override
    public List<ActivityDetails> getDetailsSelected() {
        return paymentInterfaceMapper.getDetailsSelected();
    }

    @Override
    public ActivityDetails getDetailsBySelectId(String selectedId) {
        return paymentInterfaceMapper.getDetailsById(Integer.valueOf(selectedId));
    }

    //信息添加
    @Override
    public Integer paymentInterfaceAdd(Orders orders) {
        return paymentInterfaceMapper.paymentInterfaceAdd(orders);
    }

    //详细信息添加
    @Override
    public Integer paymentInterfaceOrdersDetails(EcsServer ecsServer, String OdersUuid) {
        String content = "服务器的UUID:" + ecsServer.getSer_uuid() + ",服务器名称（用户可改）:" + ecsServer.getSer_name()
                + ",CPU核心数:" + ecsServer.getCpu() + ",内存" + ecsServer.getMemory()
                + ",系统盘大小" + ecsServer.getOs_disk() + ",拓展盘大小" + ecsServer.getOs_disk()
                + ",带宽（单位Mb）" + ecsServer.getTape() + ",IP数量" + ecsServer.getIps()
                + ",系统镜像" + ecsServer.getImage() + ",剩余天数" + ecsServer.getDays()
                + ",每月单价" + ecsServer.getPricePerMonth() + ",创建时间" + ecsServer.getCreateTime();

        return paymentInterfaceMapper.paymentInterfaceOrdersDetails(OdersUuid, content, ecsServer.getCreateTime());
    }

    //添加服务器表
    @Override
    public Integer paymentInterfaceEcsServer(EcsServer ecsServer) {
        return paymentInterfaceMapper.paymentInterfaceEcsServer(ecsServer);
    }

    //查询余额
    @Override
    public Account getMoneyByAccountUuid(@Param("uuid") String uuid) {
        return paymentInterfaceMapper.getMoneyByAccountUuid(uuid);
    }

    //支付
    @Override
    public Integer paymentInterface(Double theActualAmount, Integer score, String uuid) {
        return paymentInterfaceMapper.paymentInterface(theActualAmount, score, uuid);
    }

    //修改Orders
    @Override
    public Integer updateOrders(String ordersUuid, String uuid, Double theActualAmount, Integer month, Double pricePerMonth) {
        Double sum = theActualAmount * month;
        return paymentInterfaceMapper.updateOrders(ordersUuid, uuid, sum, pricePerMonth, month);
    }

    // 修改状态
    @Override
    public Integer paymentInterfaceOrders(@Param("ordersUuid") String ordersUuid, @Param("uuid") String uuid, @Param("state") int state) {
        return paymentInterfaceMapper.paymentInterfaceOrders(ordersUuid, uuid, state);
    }

    //补充ordersDetails
    @Override
    public Integer updateOrdersDetails(String ordersUuid, Integer month, String check_val) {
        return paymentInterfaceMapper.updateOrdersDetails(ordersUuid, month, check_val);
    }

    //修改服务
    @Override
    public Integer updateEcsServer(String uuid, String ser_uuid) {
        return paymentInterfaceMapper.updateEcsServer(uuid, ser_uuid);
    }

    //查手机号
    @Override
    public Uauth getUserPhone(String uuid) {
        return paymentInterfaceMapper.getUserPhone(uuid);
    }
}

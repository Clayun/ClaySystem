package com.mcylm.clay.service.paymentservice.service.impl;

import com.google.gson.Gson;
import com.mcylm.clay.service.paymentservice.dao.PaymentInterfaceDao;
import com.mcylm.clay.service.paymentservice.model.*;
import com.mcylm.clay.service.paymentservice.service.PaymentInterfaceService;
import com.mcylm.clay.service.paymentservice.util.Base64Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo-pc on 2017/8/7.
 */
@Service
public class PaymentInterfaceServiceImpl implements PaymentInterfaceService {

    @Autowired
    private PaymentInterfaceDao paymentInterfaceDao;

    @Override
    public Integer paymentInterface(String ordersUuid, String uuid, Double theActualAmount, Integer month, Double pricePerMonth, String check_val, Integer id, String ser_uuid) {
        //补充Orders表
        Integer o = paymentInterfaceDao.updateOrders(ordersUuid, uuid, theActualAmount, month, pricePerMonth);
        //补充ordersDetails
        if (check_val == "") {
            check_val += id;
        } else {
            check_val += "," + id;
        }


        month = month * 31;
        Integer d = paymentInterfaceDao.updateOrdersDetails(ordersUuid, month, check_val);
        //查询余额
        Account account = paymentInterfaceDao.getMoneyByAccountUuid(uuid);
        Double money = Double.valueOf(account.getMoney());
        if (money > 0.0 && theActualAmount < money) {
            Integer j = paymentInterfaceDao.paymentInterface(theActualAmount, Integer.valueOf((int) (theActualAmount / 10)), uuid);
            //支付成功后修改状态
            if (j > 0 && o > 0 && d > 0) {
                //修改服务表
                Integer s = paymentInterfaceDao.updateEcsServer(uuid, ser_uuid);
                //修改状态
                Integer i = paymentInterfaceDao.paymentInterfaceOrders(ordersUuid, uuid, 1);
                if (s > 0 && i > 0) {
                    return 1;
                }
            }
        }
        return 0;

    }


    //添加信息
    @Override
    public Integer paymentInterfaceAdd(String date) {
        Orders orders = new Orders();
        String base64String = Base64Utils.decodeBase64String(date);
        Gson gd = new Gson();
        //String数据转换ecsServer
        EcsServer ecsServer = gd.fromJson(base64String, EcsServer.class);
        orders.setOrdersUuid(ecsServer.getUuid());
        orders.setPaymentTime(ecsServer.getCreateTime());
        orders.setRemarks("聚乐云ECS弹性云服务器实例");
        orders.setState(2);
        orders.setPaymentPurposes(1);
        //添加信息表
        Integer order = paymentInterfaceDao.paymentInterfaceAdd(orders);
        //添加详细信息表
        Integer ordersDetails = paymentInterfaceDao.paymentInterfaceOrdersDetails(ecsServer, orders.getOrdersUuid());
        //添加服务器表
        Integer scsServer = paymentInterfaceDao.paymentInterfaceEcsServer(ecsServer);
        if (order > 0 && ordersDetails > 0 && scsServer > 0) {
            return 1;
        }
        return 0;
    }


    //查询活动
    @Override
    public List<ActivityDetails> getDetails() {
        return paymentInterfaceDao.getDetails();
    }

    //计算优惠后的价格
    @Override
    public Double getDetailsById(Integer month, Double entityPrice, String check_val, Integer id) {
        Double newPrice = null;
        //价钱*月份
        Double price = month * entityPrice;
        //百分比
        Double bPrice = 0.0;
        //直降
        Double zPrice = 0.0;
        //单选框优惠
        if (id != 1) {
            ActivityDetails details = paymentInterfaceDao.getDetailsById(id);
            if (details.getType().equals("1")) {
                bPrice = bPrice + Integer.valueOf(details.getNum());
            } else if (details.getType().equals("2")) {
                zPrice = zPrice + Integer.valueOf(details.getNum());
            }
        }
        //多选框优惠
        if (check_val != "") {
            String[] ids = check_val.split(",");
            for (String selectedId : ids) {
                ActivityDetails detailsSelected = paymentInterfaceDao.getDetailsBySelectId(selectedId);
                if (detailsSelected.getType().equals("1")) {
                    bPrice = bPrice + Integer.valueOf(detailsSelected.getNum());
                } else if (detailsSelected.getType().equals("2")) {
                    zPrice = zPrice + Integer.valueOf(detailsSelected.getNum());
                }
            }
        }
        //合计
        if (bPrice != 0.0 && zPrice != 0.0) {
            //全优惠
            newPrice = (price * (bPrice / 100)) - zPrice;
        } else if (bPrice != 0.0 && zPrice == 0.0) {
            //百分比优惠
            newPrice = price * (bPrice / 100);
        } else if (bPrice == 0.0 && zPrice != 0.0) {
            //直降优惠
            newPrice = price - zPrice;
        } else if (bPrice == 0.0 && zPrice == 0.0) {
            //没有优惠
            newPrice = price;
        }
        return newPrice;
    }

    //查手机号
    @Override
    public Uauth getUserPhone(String uuid) {
        return paymentInterfaceDao.getUserPhone(uuid);
    }

    //查询多选活动
    @Override
    public List<ActivityDetails> getDetailsSelected() {
        return paymentInterfaceDao.getDetailsSelected();
    }


}

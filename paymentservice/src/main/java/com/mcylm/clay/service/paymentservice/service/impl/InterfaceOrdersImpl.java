package com.mcylm.clay.service.paymentservice.service.impl;

import com.google.gson.Gson;
import com.mcylm.clay.service.paymentservice.dao.OrdersDao;
import com.mcylm.clay.service.paymentservice.model.Account;
import com.mcylm.clay.service.paymentservice.model.ActivityDetails;
import com.mcylm.clay.service.paymentservice.model.Orders;
import com.mcylm.clay.service.paymentservice.service.InterfaceOrders;
import com.mcylm.clay.service.paymentservice.util.Base64Utils;
import com.mcylm.clay.service.paymentservice.util.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo-pc on 2017/8/7.
 */
@Service
public class InterfaceOrdersImpl implements InterfaceOrders {

    @Autowired
    private OrdersDao ordersDao;

    @Override
    public Integer paymentInterface(@Param("ordersUuid") String ordersUuid, @Param("uuid") String uuid, @Param("theActualAmount") Integer theActualAmount) {
        //查询余额
        Account account = ordersDao.getMoneyByAccountUuid(uuid);
        String money = account.getMoney();
        if (Long.valueOf(money) > 0 && theActualAmount < Long.valueOf(money)) {
            Integer j = ordersDao.paymentInterface(theActualAmount, Integer.valueOf((theActualAmount / 10)), uuid);
            //支付成功后修改状态
            if (j > 0) {
                //修改状态
                Integer i = ordersDao.paymentInterfaceOrders(ordersUuid, uuid, 4);
                return 1;
            }
        }
        return 0;

    }

   /* @Override
    public Orders getOrdersByUuid(String uuid) {
        return ordersDao.getOrdersByUuid(uuid);
    }*/

    //添加信息
    @Override
    public Orders paymentInterfaceAdd(String data) {
        //信息解密
        String s = Base64Utils.decodeBase64String(data);
        Gson g = new Gson();
        //String数据转换Order
        Orders orders = g.fromJson(s, Orders.class);
        //new订单编号
        String ordersUuid = StringUtils.getUuid();
        orders.setOrdersUuid(ordersUuid);
        //添加信息表
        Integer i = ordersDao.paymentInterfaceAdd(orders);
        //添加详细信息表
        Integer j = ordersDao.paymentInterfaceOrdersDetails(orders);
        if (i > 0 && j > 0) {
            Orders order = ordersDao.getOrdersByUuid(orders.getUuid(), ordersUuid);
            return order;
        }
        return null;
    }

    //查询活动
    @Override
    public List<ActivityDetails> getDetails() {
        return ordersDao.getDetails();
    }

    //计算优惠后的价格
    @Override
    public Double getDetailsById(Integer month, Integer entityPrice, String check_val, Integer id) {
        Double newPrice = null;
        //价钱*月份
        Integer price = month * entityPrice;
        //百分比
        Double bPrice = 0.0;
        //直降
        Integer zPrice = 0;
        //单选框优惠
        if (id != 1) {
            ActivityDetails details = ordersDao.getDetailsById(id);
            System.out.println("details=======" + details);
            if (details.getType().equals("1")) {
                bPrice = bPrice + Integer.valueOf(details.getNum());
                System.out.println("1***" + bPrice);
            } else if (details.getType().equals("2")) {
                zPrice = zPrice + Integer.valueOf(details.getNum());
                System.out.println("2***" + zPrice);
            }
        }
        //多选框优惠
        if (check_val != "") {
            String[] ids = check_val.split(",");
            for (String selectedId : ids) {
                ActivityDetails detailsSelected = ordersDao.getDetailsBySelectId(selectedId);
                if (detailsSelected.getType().equals("1")) {
                    bPrice = bPrice + Integer.valueOf(detailsSelected.getNum());
                    System.out.println("3***" + bPrice);
                } else if (detailsSelected.getType().equals("2")) {
                    zPrice = zPrice + Integer.valueOf(detailsSelected.getNum());
                    System.out.println("4***" + zPrice);
                }
            }
        }
        //合计
        if (bPrice != 0 && zPrice != 0) {
            //全优惠
            newPrice = (Double.valueOf(price) * Double.valueOf(bPrice / 100)) - zPrice;
            System.out.println("5*****" + newPrice);
        } else if (bPrice != 0 && zPrice == 0) {
            //百分比优惠
            newPrice = Double.valueOf(price) * Double.valueOf(bPrice / 100);
            System.out.println("6****" + newPrice);
        } else if (bPrice == 0 && zPrice != 0) {
            //直降优惠
            newPrice = Double.valueOf(price - zPrice);
            System.out.println("7****" + newPrice);
        } else if (bPrice == 0 && zPrice == 0) {
            //没有优惠
            newPrice = Double.valueOf(price);
            System.out.println("8****" + newPrice);
        }
        System.out.println("9****" + newPrice);
        return newPrice;
    }

    @Override
    public List<ActivityDetails> getDetailsSelected() {
        return ordersDao.getDetailsSelected();
    }

    @Override
    public int withdrawalInterface(Orders orders) {
        return 0;
    }

    @Override
    public int rechargeInterface(Orders orders) {
        return 0;
    }


}

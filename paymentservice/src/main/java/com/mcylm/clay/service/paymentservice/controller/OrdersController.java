package com.mcylm.clay.service.paymentservice.controller;

import com.mcylm.clay.service.paymentservice.model.Orders;
import com.mcylm.clay.service.paymentservice.service.InterfaceOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * Created by lenovo-pc on 2017/8/7.
 */
@Controller
public class OrdersController {
    @Autowired
    private InterfaceOrders interfaceOrders;

    /***
     * 作者：hanguoli
     * 时间：2017-8-7 20:51:00
     * 功能：支付接口
     * param：（uuid,paymentAmount,paymentPurposes,remarks,paymentTime）
     * @return
     */
    @RequestMapping(value = "/paymentInterface")
    private ModelAndView paymentInterface(Orders orders) {
        orders.setUuid("1");
        Date date = new Date();
        orders.setPaymentTime(date);
        orders.setRemarks("测试数据");
        orders.setTheActualAmount(100);
        ModelAndView m = new ModelAndView();
        m.addObject("orders", orders);
        m.setViewName("orderPay");
        return m;
    }

    /**
     *
     * @param aa
     * @param serverId
     * @return
     */
    @RequestMapping(value = "/getorderMonthPrice")
    @ResponseBody
    private Integer getorderMonthPrice(String aa,String serverId) {
        int i = Integer.valueOf(aa) * Integer.valueOf(serverId);
        System.out.println(i);
        return i;
    }

    /**
     * 支付
     * @param
     * @returnOrders orders
     */
    @RequestMapping(value = "/payment")
    @ResponseBody
    public boolean payment(String uuid,String remarks,Integer theActualAmount) {
        Orders orders = new Orders();
        orders.setTheActualAmount(theActualAmount);
        //orders.setRemarks(remarks);
        orders.setUuid(uuid);
        /*orders.setPaymentTime(paymentTime);*/
       Integer i = interfaceOrders.paymentInterface(orders);
        return i>0;
    }

    /***
     * 作者：hanguoli
     * 时间：2017-8-8 18:56:13
     * 功能：充值接口展示列表
     * param：（uuid,paymentAmount,paymentPurposes,remarks,paymentTime）
     * @return
     */
    @RequestMapping(value = "/paymentInterfaceList")
    private ModelAndView paymentInterfaceList() {
        ModelAndView m = new ModelAndView();
        List<Orders> ordersList = interfaceOrders.paymentInterfaceList();
        m.addObject("ordersList", ordersList);
        m.setViewName("paymentInterfaceList");
        for (Orders orders : ordersList) {
            System.out.println(orders);
        }
        return m;
    }

    /*//测试
    @RequestMapping(value = "/index")
    private String withdrawalInterface() {
        return "index";
    }*/

    /***
     * 作者：hanguoli
     * 时间：2017-8-8 14:55:43
     * 功能：提现接口
     * param：（uuid,paymentAmount,paymentPurposes,remarks,paymentTime）
     * @return
     */
    @RequestMapping(value = "/withdrawalInterface")
    @ResponseBody
    private ResponseEntity<Boolean> withdrawalInterface(Orders orders) {
        return ResponseEntity.status(HttpStatus.OK).body(interfaceOrders.withdrawalInterface(orders) > 0);
    }

    /***
     * 作者：hanguoli
     * 时间：2017-8-8 14:55:55
     * 功能：充值接口
     * param：（uuid,paymentAmount,paymentPurposes,remarks,paymentTime）
     * @return
     */
    @RequestMapping(value = "/rechargeInterface")
    private ResponseEntity<Boolean> rechargeInterface(@RequestParam("Orders") Orders orders) {
        return ResponseEntity.status(HttpStatus.OK).body(interfaceOrders.rechargeInterface(orders) > 0);
    }

    /**
     * 显示
     * @param date
     * @return
     */
    @RequestMapping(value = "/getUserPhone")
    @ResponseBody
    private String getUserPhone(String date) {
        System.out.println("*************"+date+"*************");
        String phone ="13240359049";
        return phone;
    }
    /**
     * 显示
     * @param
     * @return
     */
    @RequestMapping(value = "/verphone")
    @ResponseBody
    private Boolean verphone(String verphone) {
        System.out.println("*************"+verphone+"*************");
       if("1234".equals(verphone)){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * 接收手机号
     * @param phone
     * @param request
     * @return
     */
    @RequestMapping(value = "/valphonewhatever")
    @ResponseBody
    private String valphonewhatever(String phone, HttpServletRequest request) {
        //SMSMessageLib.send(phone,request);
        return "success";
    }




}

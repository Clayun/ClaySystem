package com.mcylm.clay.service.paymentservice.controller;

import com.mcylm.clay.service.paymentservice.model.ActivityDetails;
import com.mcylm.clay.service.paymentservice.model.Orders;
import com.mcylm.clay.service.paymentservice.model.ParameterModel;
import com.mcylm.clay.service.paymentservice.service.InterfaceOrders;
import com.mcylm.clay.service.paymentservice.util.Base64Utils;
import com.mcylm.clay.service.paymentservice.util.RedisUtils;
import com.mcylm.clay.service.paymentservice.util.SMSMessageLib;
import com.mcylm.clay.service.paymentservice.util.StringUtils;
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
import java.util.*;

import static com.mcylm.clay.service.paymentservice.util.RedisUtils.checkTokenExit;

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
    public String paymentInterface(ParameterModel parameterModel, String formToken, String data, HttpServletRequest request) {
        Orders order = null;
        String orderPay = null;
        Map m = new HashMap();
        //判读是否存进redis
        boolean b = checkTokenExit(Base64Utils.decodeBase64String(formToken));
        //检测是否登录
        orderPay = RedisUtils.checkLogin(parameterModel, "orderPay");
        if (!b) {
            //获取当前地址
            StringBuffer url = request.getRequestURL();
            //信息存入redis
            RedisUtils.setKey_Val_TimeOut(formToken, data);
            parameterModel.setRedirectUrl(url.toString());
            //信息添加及回显
            order = interfaceOrders.paymentInterfaceAdd(data);
        }
        //查询优惠信息回显
        List<ActivityDetails> detail = interfaceOrders.getDetails();
        List<ActivityDetails> details = interfaceOrders.getDetailsSelected();
        m.put("order", order);
        m.put("detail", detail);
        m.put("details", details);
        return orderPay;
    }

    /**
     * 跳转页面价钱回显计算
     *
     * @param aa
     * @param serverId
     * @return
     */
    @RequestMapping("/getMonthPrice")
    @ResponseBody
    public Integer getMonthPrice(Integer aa, Integer serverId) {
        return aa * serverId;
    }

    /**
     * 计算价钱
     *
     * @param month
     * @param entityPrice
     * @param check_val
     * @param id
     * @return Double
     */
    @RequestMapping(value = "/getorderMonthPrice")
    @ResponseBody
    private Double getorderMonthPrice(Integer month, Integer entityPrice, String check_val, Integer id) {
        System.out.println("1--------------" + month);
        System.out.println("2--------------" + entityPrice);
        System.out.println("3--------------" + check_val);
        System.out.println("4--------------" + id);
        return interfaceOrders.getDetailsById(month, entityPrice, check_val, id);
    }


    /**
     * 支付并修改状态
     *
     * @param
     * @returnOrders orders
     */
    @RequestMapping(value = "/payment")
    @ResponseBody
    public boolean payment(String ordersUuid, String uuid, Integer theActualAmount) {
        return interfaceOrders.paymentInterface(ordersUuid, uuid, theActualAmount) > 0;
    }

    /***
     * 作者：hanguoli
     * 时间：2017-8-8 14:55:43
     * 功能：提现接口
     * @param orders
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
     *
     * @param date
     * @return
     */
    @RequestMapping(value = "/getUserPhone")
    @ResponseBody
    public String getUserPhone(String date, HttpServletRequest request) {
        String phone = String.valueOf(request.getSession().getAttribute("phone"));
        System.out.println("*************" + date + "*************");
        return phone;
    }

    /**
     * 显示
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/verphone")
    @ResponseBody
    public Boolean verphone(String verphone, HttpServletRequest request) {
        String phonever = (String) request.getSession().getAttribute("phonever");
        System.out.println("=============phonever============" + phonever);
        System.out.println("*************" + verphone + "*************");
        if (phonever.equals(verphone))
            return true;
        else
            return false;

    }

    /**
     * 接收手机号
     *
     * @param phone
     * @param request
     * @return
     */
    @RequestMapping(value = "/valphonewhatever")
    @ResponseBody
    public String valphonewhatever(String phone, HttpServletRequest request) {
        request.getSession().setAttribute("phone", phone);
       // request.getSession().setAttribute("phonever", "1234");
        SMSMessageLib.send(phone,request);
        return "success";
    }


}

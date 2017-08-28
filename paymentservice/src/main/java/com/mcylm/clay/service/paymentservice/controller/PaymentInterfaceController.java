package com.mcylm.clay.service.paymentservice.controller;

import com.google.gson.Gson;
import com.mcylm.clay.service.paymentservice.model.*;
import com.mcylm.clay.service.paymentservice.service.PaymentInterfaceService;
import com.mcylm.clay.service.paymentservice.util.Base64Utils;
import com.mcylm.clay.service.paymentservice.util.RedisUtils;
import com.mcylm.clay.service.paymentservice.util.SMSMessageLib;
import com.mcylm.clay.service.paymentservice.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by lenovo-pc on 2017/8/7.
 */
@Controller
public class PaymentInterfaceController {
    @Autowired
    private PaymentInterfaceService paymentInterfaceService;

    /***
     * 作者：hanguoli
     * 时间：2017-8-7 20:51:00
     * 功能：支付接口
     * param：（uuid,paymentAmount,paymentPurposes,remarks,paymentTime）
     * @return
     */
    @RequestMapping(value = "/paymentInterface")
    public String paymentInterface(ParameterModel parameterModel, Model model, HttpServletRequest request, String data) {
        boolean flag = false;
        EcsServer ecsServer = null;
        //随机formToken
        String formToken = StringUtils.getUuid();

        //判断formtoken是否为空
        if (parameterModel.getFormToken() == null || "".equals(formToken)) {
            //赋值  一个加密的formToken
            parameterModel.setFormToken(Base64Utils.encodeBase64String(formToken));
        }

        //获取redis中提交的数据
        String valByKey = RedisUtils.getValByKey(Base64Utils.decodeBase64String(parameterModel.getFormToken()));

        //判断redis中是否已经有对应的商品信息
        if (valByKey != null && !"".equals(valByKey)) {
            flag = true;
            //信息解密
            String s = Base64Utils.decodeBase64String(valByKey);
            Gson gd = new Gson();
            //String数据转换ecsServer
            ecsServer = gd.fromJson(s, EcsServer.class);
        }

        //获取当前地址
        StringBuffer url = request.getRequestURL();
        url.replace(16, 22, "/pay/");
        parameterModel.setRedirectUrl(url.toString());
        //检测是否登录
        String orderPay = RedisUtils.checkLogin(parameterModel, "orderPay");

        if (!flag) {
            //信息存入redis
            try {
                RedisUtils.setKey_Val_TimeOut(Base64Utils.decodeBase64String(parameterModel.getFormToken()), data);
            } catch (Exception e) {
                return "redirect:http://localhost/ecs/enterprise/create?token="+parameterModel.getToken();
            }
            //信息添加
            Integer i = paymentInterfaceService.paymentInterfaceAdd(data);
        }

        if (flag) {
            //查询优惠信息回显
            List<ActivityDetails> detail = paymentInterfaceService.getDetails();
            List<ActivityDetails> details = paymentInterfaceService.getDetailsSelected();
            model.addAttribute("id", parameterModel.getToken());
            model.addAttribute("ecsServer", ecsServer);
            model.addAttribute("detail", detail);
            model.addAttribute("details", details);
        }
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
    public String getMonthPrice(Integer aa, Double serverId) {
        return new java.text.DecimalFormat("#.00").format(aa * serverId);
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
    private String getorderMonthPrice(Integer month, Double entityPrice, String check_val, Integer id) {
        Double d = paymentInterfaceService.getDetailsById(month, entityPrice, check_val, id);
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(d);
    }

    /**
     * 查手机号
     *
     * @param uuid
     * @return
     */
    @RequestMapping("/getUserPhone")
    @ResponseBody
    public String getUserPhone(String uuid) {
        String uuid1 = this.getUUidByToken(uuid);
        Uauth uauth = paymentInterfaceService.getUserPhone(uuid1);
        return uauth.getPhone();
    }

    /**
     * 支付并修改状态
     *
     * @param ordersUuid
     * @param uuid
     * @param theActualAmount
     * @param month
     * @param pricePerMonth
     * @param check_val
     * @param id
     * @param ser_uuid
     * @return
     */
    @RequestMapping(value = "/payment")
    @ResponseBody
    public boolean payment(String ordersUuid, String uuid, Double theActualAmount, Integer month, Double pricePerMonth, String check_val, Integer id, String ser_uuid) {
        String uuid1 = this.getUUidByToken(uuid);
        return paymentInterfaceService.paymentInterface(ordersUuid, uuid1, theActualAmount, month, pricePerMonth, check_val, id, ser_uuid) > 0;
    }

    //根据token获取uuid
    public String getUUidByToken(String uuid) {

        String valByKey = RedisUtils.getValByKey(Base64Utils.decodeBase64String(uuid));
        Gson gson = new Gson();
        UauthToken uauthToken = gson.fromJson(valByKey, UauthToken.class);
        return uauthToken.getUuid();
    }

    /**
     * 显示
     *
     * @param
     * @return
     */
    String phonever = "";

    @RequestMapping(value = "/verphone")
    @ResponseBody
    public Boolean verphone(String verphone, HttpServletRequest request) {
        if (verphone.equals(phonever)) {
            phonever = "";
            return true;
        } else {
            return false;
        }

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
        SMSMessageLib.send(phone, request);
        String phonever1 = (String) request.getSession().getAttribute("phonever");
        phonever = phonever1;
        return "success";
    }
}

package com.mcylm.clay.service.paymentservice.controller;

import com.mcylm.clay.service.paymentservice.model.ParameterModel;
import com.mcylm.clay.service.paymentservice.service.RechargeInterfaceService;
import com.mcylm.clay.service.paymentservice.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lenovo-pc on 2017/8/17.
 */
/*@Controller*/
public class RechargeInterfaceController {
   /* @Autowired
    private RechargeInterfaceService rechargeInterfaceService;*/
    @RequestMapping("/rechargeInterface")
    public String rechargeInterface(ParameterModel parameterModel, Model model, HttpServletRequest request){
        //获取当前地址
        StringBuffer url = request.getRequestURL();
        parameterModel.setRedirectUrl(url.toString());
        //检测是否登录
        String index = RedisUtils.checkLogin(parameterModel, "index");
        return index;
    }
}

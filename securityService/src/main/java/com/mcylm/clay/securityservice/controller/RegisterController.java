package com.mcylm.clay.securityservice.controller;

import com.mcylm.clay.securityservice.module.ParameterModel;
import com.mcylm.clay.securityservice.service.UserRegisterService;
import com.mcylm.clay.securityservice.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author:Wuyali
 * @Description:
 * @Date:Created in 15:07 2017/8/8
 * @Modified By:
 */
@Controller
public class RegisterController {
    @Autowired
    private UserRegisterService userRegisterService;

    //注册
    @RequestMapping("/register")
    public String register(ParameterModel parameterModel){

        System.out.println("=============");
        return RedisUtils.checkLogin(parameterModel,"register");
    }
}

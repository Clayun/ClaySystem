package com.mcylm.clay.securityservice.controller;

import com.mcylm.clay.securityservice.service.UserRegisterService;
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
    public String register(){
        System.out.println("=============");
        return "register";
    }
}

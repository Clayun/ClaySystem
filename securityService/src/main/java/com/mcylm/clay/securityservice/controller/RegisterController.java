package com.mcylm.clay.securityservice.controller;

import com.mcylm.clay.securityservice.service.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author:Wuyali
 * @Description:
 * @Date:Created in 15:07 2017/8/8
 * @Modified By:
 */
@Controller
@RequestMapping("/author")
public class RegisterController {
    @Autowired
    private UserRegisterService userRegisterService;

    //注册
    @RequestMapping("/register")
    public String register() {
        return "register";
    }


    //验证名称
    @RequestMapping("/verifyRegisterUserInfo")
    @ResponseBody
    public String  verifyRegisterUserInfo(String userName, String phone,String vpwd, String email, String passWord) {
        System.out.println("lalala=====" + userName);
        String info  = userRegisterService.verifyRegisterUserInfo(userName,phone,vpwd,email,passWord);
        return info;
    }

}

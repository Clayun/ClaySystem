package com.mcylm.clay.securityservice.controller;

import com.mcylm.clay.securityservice.service.UauthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lenovo on 2017/8/7.
 */

/**
 * 登录
 */
@Controller
@RequestMapping("/author")
public class LoginContoller {

    @Autowired
    private UauthService uauthService;

    @RequestMapping(value = "/login")
    public String toLogin(){
        System.out.println("========================");
        System.out.println("========================");
        System.out.println("========================");
        return "login";
    }


}

package com.mcylm.clay.service.userservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Mikesam on 2017/8/4.
 */
@RestController
public class UserController {

    @RequestMapping("hello")
    public String test(HttpServletResponse response,String username){
        return "hello,"+username;
    }

}

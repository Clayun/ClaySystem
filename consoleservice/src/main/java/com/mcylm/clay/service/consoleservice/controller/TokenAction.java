package com.mcylm.clay.service.consoleservice.controller;

import com.mcylm.clay.service.consoleservice.model.Token;
import com.mcylm.clay.service.consoleservice.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Map;

/**
 * @Author:Mr_Shen
 * @Description: - -!
 * @Date:2017/8/17/017
 * @Modified By:None one
 */
@Controller
@RequestMapping("/token")
public class TokenAction {

    @Autowired
    private TokenService tokenService;

    @RequestMapping("/tokenlist")
    public String tokenlist(Map<String,Object> map){
        List<Token> list=tokenService.getOrderList();
        map.put("list",list);
        return "token";
    }

}
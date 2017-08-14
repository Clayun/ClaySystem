package com.mcylm.clay.service.consoleservice.controller;

import com.mcylm.clay.service.consoleservice.model.Account;
import com.mcylm.clay.service.consoleservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Map;

/**
 * @Author:Mr_Shen
 * @Description: - -!
 * @Date:2017/8/14/014
 * @Modified By:None one
 */
@Controller
@RequestMapping("/account")
public class AccountAction {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/accountlist")
    public String accountlist(Map<String,Object> map){
        List<Account> list=accountService.getaccountlist();
        map.put("list",list);
        return "account";
    }
}
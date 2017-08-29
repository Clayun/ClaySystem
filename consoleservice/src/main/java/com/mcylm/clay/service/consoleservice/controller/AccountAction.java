package com.mcylm.clay.service.consoleservice.controller;

import com.mcylm.clay.service.consoleservice.model.Account;
import com.mcylm.clay.service.consoleservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
        List<Account> list=accountService.getaccountlist(map);
        map.put("list",list);
        return "account";
    }

    //添加
    @RequestMapping(value="/accountadd",method= RequestMethod.POST)
    @ResponseBody
    public boolean toadd(Account account){
        try {
            //获取UUID
            UUID uuid=UUID.randomUUID();
            String str = uuid.toString();
            String uuidStr=str.replace("-", "");
            account.setUuid(uuidStr);
            //获取当前创建时间
            accountService.ucenteradd(account);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    //修改
    @RequestMapping(value="/accountupdate",method = RequestMethod.POST)
    @ResponseBody
    public boolean accountupdate(Account account){
        try {
            accountService.accountupdate(account);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    //删除
    @RequestMapping(value="/accountdel",method= RequestMethod.POST)
    @ResponseBody
    public boolean accountdel(Integer id){
        try{
            accountService.accountdel(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
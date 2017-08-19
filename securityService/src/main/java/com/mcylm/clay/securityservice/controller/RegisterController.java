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


    //验证手机号唯一  发送信息
  /*  @RequestMapping("/verifyRegisterPhone")
    @ResponseBody
    public String verifyRegisterPhone(String phone) {
        System.out.println("lalala=====" + phone);

       Uauth uauth = userRegisterService.findRegisterByPhone(phone);
        if (uauth != null) {
            return null;
        }
        System.out.println("phone================" + phone);
        SMSMessageLib01.send(phone,request);

        return send;
        return "";
    }*/

    //验证名称
    @RequestMapping("/verifyRegisterUserInfo")
    @ResponseBody
    public String  verifyRegisterUserInfo(String userName, String phone,String vpwd, String email, String passWord) {
        System.out.println("lalala=====" + userName);
        String info  = userRegisterService.verifyRegisterUserInfo(userName,phone,vpwd,email,passWord);
        return info;
    }
   /* @RequestMapping("/lianguoshuai")
    public  void  lianguoshuai(HttpServletRequest request){

        SMSMessage.send("15010622598",request);
        System.out.println("phoneverphoneverphoneverphonever***");
    }*/
}

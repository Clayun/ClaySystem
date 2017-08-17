package com.mcylm.clay.securityservice.controller;

import com.mcylm.clay.securityservice.module.Uauth;
import com.mcylm.clay.securityservice.service.UserRegisterService;
import com.mcylm.clay.securityservice.util.SMSMessageLib;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
    public String register(){
        return  "register";
    }

    //验证成功后注册
    @RequestMapping("/insertRegisterUser")
    @ResponseBody
    public  boolean insertResisterInfo(String userName,String phone,String email,String passWord){
         System.out.println(userName);
         System.out.println(phone);

         boolean flag =  userRegisterService.insertResisterInfo(userName,phone,email,passWord);
         System.out.println("hahahahahah"+flag);
         return flag;

    }

//验证手机号唯一  发送信息
    @RequestMapping("/verifyRegisterPhone")
    @ResponseBody
    public String  verifyRegisterPhone(String phone,HttpServletRequest request){
        System.out.println("lalala====="+phone);

        Uauth uauth = userRegisterService.findRegisterByPhone(phone);
        if(uauth!=null){
            return "failed";
        }else {
            System.out.println("phone================"+phone);
            String send = SMSMessageLib.send(phone, request);
            System.out.println("手机验证码***********"+send);
            return  "success";
        }
    }
    //验证名称
    @RequestMapping("/verifyRegisterName")
    @ResponseBody
     public Uauth verifyRegisterName(String username){
       System.out.println("lalala====="+username);
       Uauth uauth = userRegisterService.findRegisterByPhone(username);
       return  uauth;
   }

@RequestMapping("/verifyPhone")
@ResponseBody
public String verifyPhone(HttpServletRequest request, HttpServletResponse response,String verphone) throws IOException{
        if(String.valueOf(request.getSession().getAttribute("phonever")).equals(verphone)){
             request.getSession().setAttribute("phonever",SMSMessageLib.random());
            return  "success";

        }else {
            return  "failed";
        }

}


}

package com.mcylm.clay.service.consoleservice.controller;

import com.mcylm.clay.service.consoleservice.model.Login;
import com.mcylm.clay.service.consoleservice.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author:Mr_Shen
 * @Description: 登录!
 * @Date:2017/8/24/024
 * @Modified By:None one
 */

@Controller
public class LoginAction{

    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("tologin")
    @ResponseBody
    public boolean tologin(String username, String password, HttpServletRequest request){
        Login login=new Login();
        login.setUsername(username);
        login.setPassword(password);
        try {
            Login LoginMessage=loginService.tologin(login);
            if(LoginMessage.getId()!=null){
                HttpSession session=request.getSession();
                session.setAttribute("username",username);
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }
}
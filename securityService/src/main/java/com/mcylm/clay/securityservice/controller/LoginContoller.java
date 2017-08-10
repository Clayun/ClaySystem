package com.mcylm.clay.securityservice.controller;

import com.mcylm.clay.securityservice.config.GeetestConfig;
import com.mcylm.clay.securityservice.sdk.GeetestLib;
import com.mcylm.clay.securityservice.service.UauthService;
import com.mcylm.clay.securityservice.util.IPUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lenovo on 2017/8/7.
 * 登录控制层
 */
@Controller
@RequestMapping("/author")
public class LoginContoller {
    @Autowired
    private UauthService uauthService;
    /**
     * 跳转到登录页面
     *
     * @return
     */
    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    /**
     * 登录
     * @param request
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/doLogin")
    @ResponseBody
    public ResponseEntity doLogin(HttpServletRequest request, String username, String password) {
        //客户端ip
        String hostIp = IPUtil.getIpAddr(request);
        //主机ip
        String sessionId = request.getSession().getId();
        ResponseEntity result = uauthService.getUuidByUsernameAndPassword(username, password,hostIp,sessionId);
        return result;
    }


    @RequestMapping("/getVerificationCode")
    @ResponseBody
    public String startCaptchaServlet(HttpServletRequest request, String dateTime) {
        GeetestLib gtSdk = new GeetestLib(GeetestConfig.getGeettestId(), GeetestConfig.getGeetestKey(),
                GeetestConfig.isNEWFAILBACK());
        String resStr = "{}";
        //自定义userid
        String userid = dateTime;
        //进行验证预处理
        int gtServerStatus = gtSdk.preProcess(userid);
        //将服务器状态设置到session中
        request.getSession().setAttribute(gtSdk.gtServerStatusSessionKey, gtServerStatus);
        //将userid设置到session中
        request.getSession().setAttribute("userid", userid);
        resStr = gtSdk.getResponseStr();
        return resStr;
    }

   /* @RequestMapping("/getIpAddr")
    */



}

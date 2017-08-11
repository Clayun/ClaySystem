package com.mcylm.clay.securityservice.controller;

import com.mcylm.clay.securityservice.config.GeetestConfig;
import com.mcylm.clay.securityservice.module.ParameterModel;
import com.mcylm.clay.securityservice.sdk.GeetestLib;
import com.mcylm.clay.securityservice.service.UauthService;
import com.mcylm.clay.securityservice.util.Base64Utils;
import com.mcylm.clay.securityservice.util.IPUtil;
import com.mcylm.clay.securityservice.util.RedisUtils;
import com.sun.xml.internal.rngom.parse.host.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

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
    public String login(Map<String, Object> map, ParameterModel parameterModel) {
        boolean flag = false;
        String redirectUrl = parameterModel.getRedirectUrl();
        String token = parameterModel.getToken();

        if (redirectUrl != null && !"".equals(redirectUrl)) {
            map.put("redirectUrl", redirectUrl);
        } else {
            map.put("redirectUrl", "");
        }

        if (token != null && !"".equals(token)) {
            //解密并判断
//            flag = uauthService.checkTokenExit(token);
            flag = RedisUtils.checkTokenExit(token);
        }

        if (flag)
            return "redirect:http://"+redirectUrl+"?token="+token+"&loginType="+Base64Utils.encodeBase64String("autoLogin");
        return "login";
    }

    /**
     * 登录
     *
     * @param request
     * @param parameterModel
     * @return
     */
    @RequestMapping("/doLogin")
    @ResponseBody
    public ResponseEntity<ParameterModel> doLogin(HttpServletRequest request, ParameterModel parameterModel) {
        //客户端ip
        String hostIp = IPUtil.getIpAddr(request);
        //主机ip
        String sessionId = request.getSession().getId();
        ResponseEntity<ParameterModel> result = uauthService.getUuidByUsernameAndPassword(parameterModel, hostIp, sessionId);
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

}

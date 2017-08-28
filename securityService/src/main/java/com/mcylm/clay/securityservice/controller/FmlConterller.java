package com.mcylm.clay.securityservice.controller;

import com.mcylm.clay.securityservice.config.GeetestConfig;
import com.mcylm.clay.securityservice.module.ParameterModel;
import com.mcylm.clay.securityservice.sdk.GeetestLib;
import com.mcylm.clay.securityservice.util.Base64Utils;
import com.mcylm.clay.securityservice.util.RedisUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by lenovo on 2017/8/12.
 * 功能：页面跳转和处理
 */
@Controller
@RequestMapping("/author")
public class FmlConterller {

    /**
     * 跳转到登录页面
     *
     * @return
     */
    @RequestMapping(value = "/login")
    public String login(Map<String, Object> map, ParameterModel parameterModel) {
        boolean flag = false;
        //获取请求的路径
        String redirectUrl = parameterModel.getRedirectUrl();
        //过去用户登录token
        String token = parameterModel.getToken();

        //判断跳转的 url 是否为空
        if (redirectUrl != null && !"".equals(redirectUrl)) {
            map.put("redirectUrl", redirectUrl);
        } else{
            map.put("redirectUrl", "");
        }

        //解密并判断
        if (token != null && !"".equals(token)) {
            flag = RedisUtils.checkTokenExit(token);
        }

        //如果没有登录就跳转到登录页面
        if (flag) {
            return "redirect:http://" + redirectUrl + "?token=" + token + "&loginType=" + Base64Utils.encodeBase64String("autoLogin");
        }
        return "login";
    }

    /**
     * 功能：验证码
     *
     * @param request
     * @param dateTime
     * @return
     */
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


    /**
     * 跳转到修改密码页面
     *
     * @return
     */
    @RequestMapping("/resetpwd")
    public String unknown() {
        return "resetpwd";
    }
}

package com.mcylm.clay.securityservice.service.impl;

import com.google.gson.Gson;
import com.mcylm.clay.securityservice.dao.UauthDao;
import com.mcylm.clay.securityservice.module.ParameterModel;
import com.mcylm.clay.securityservice.module.Uauth;
import com.mcylm.clay.securityservice.module.UauthToken;
import com.mcylm.clay.securityservice.service.UauthService;
import com.mcylm.clay.securityservice.service.UauthTokenService;
import com.mcylm.clay.securityservice.util.Base64Utils;
import com.mcylm.clay.securityservice.util.MD5Util;
import com.mcylm.clay.securityservice.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lenovo on 2017/8/7.
 */
@Service
public class UauthServiceImpl implements UauthService {

    @Autowired
    private UauthDao uauthDao;

    @Autowired
    private UauthTokenService uauthTokenService;

    /**
     * 登录获取uuid
     *
     * @param parameterModel
     * @return
     */
    @Override
    public ResponseEntity<ParameterModel> getUuidByUsernameAndPassword(ParameterModel parameterModel, String hostIp, String sessionId,HttpServletRequest request,HttpServletResponse response) {
        //MD5加密数据
        Uauth uauth = uauthDao.getUuidByUsernameAndPassword(parameterModel.getUsername());
        parameterModel.setStatus("510");

        if (uauth != null && uauth.getUuid() != null && !"".equals(uauth.getUuid())) {
            boolean flag = MD5Util.verify(parameterModel.getPassword(), uauth.getPassWord());
            //密码清空
            parameterModel.setPassword(null);

            if (flag) {
                //把用户登录信息存入token
                UauthToken uauthToken = uauthTokenService.insertUauthTokenMessage(uauth.getUuid(), hostIp, sessionId);

                if (uauthToken != null) {
                    //将信息存入redis中
                    RedisUtils.setKey_Val_TimeOut(uauthToken.getToken(), uauthToken);
                    parameterModel.setToken(Base64Utils.encodeBase64String(uauthToken.getToken()));
                    parameterModel.setStatus("201");
                    parameterModel.setLoginType(Base64Utils.encodeBase64String("logined"));
                    request.getSession().setAttribute("token",Base64Utils.encodeBase64String(uauthToken.getToken()));
                    Cookie cookie = new Cookie("token", Base64Utils.encodeBase64String(uauthToken.getToken()));
                    cookie.setMaxAge(30*60);
                    response.addCookie(cookie);
                    //登录成功
                    return ResponseEntity.ok().body(parameterModel);
                }

            }

        }
        //登录失败
        return ResponseEntity.ok().body(parameterModel);
    }

    @Override
    public Uauth checkName(ParameterModel parameterModel) {
        return uauthDao.checkName(parameterModel);
    }

    @Override
    public String updatePassword(String password, String phone) {
        try {
            uauthDao.updatePassword(MD5Util.generate(password), phone);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "falid";
        }
    }

    /**
     * 根据token 判断是否登录，
     * 登录 返回用户信息，
     * 否则返回null
     * @param token
     * @return
     */
    @Override
    public Uauth checkLogin(String token) {
        boolean b = RedisUtils.checkTokenExit(token);
        if (b) {
            String valByKey = RedisUtils.getValByKey(Base64Utils.decodeBase64String(token));
            Gson gson = new Gson();
            UauthToken uauthToken = gson.fromJson(valByKey, UauthToken.class);
            String uuid = uauthToken.getUuid();
            Uauth uauth = uauthDao.getUauthByUuid(uuid);
            return uauth;
        }
        return null;
    }

    /**
     * 退出登录
     * @param token
     * @return
     */
    @Override
    public boolean logout(String token) {
        RedisUtils.deleteValByTocken(token);
        return true;
    }


}

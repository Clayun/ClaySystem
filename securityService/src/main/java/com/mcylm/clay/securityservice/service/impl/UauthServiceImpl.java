package com.mcylm.clay.securityservice.service.impl;

import com.mcylm.clay.securityservice.dao.UauthDao;
import com.mcylm.clay.securityservice.module.ParameterModel;
import com.mcylm.clay.securityservice.module.Uauth;
import com.mcylm.clay.securityservice.module.UauthToken;
import com.mcylm.clay.securityservice.service.RedisService;
import com.mcylm.clay.securityservice.service.UauthService;
import com.mcylm.clay.securityservice.service.UauthTokenService;
import com.mcylm.clay.securityservice.util.Base64Utils;
import com.mcylm.clay.securityservice.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Created by lenovo on 2017/8/7.
 */
@Service
public class UauthServiceImpl implements UauthService {

    @Autowired
    private UauthDao uauthDao;

    @Autowired
    private UauthTokenService uauthTokenService;

    @Autowired
    private RedisService redisService;

    /**
     * 登录获取uuid
     *
     * @param parameterModel
     * @return
     */
    @Override
    public ResponseEntity<ParameterModel> getUuidByUsernameAndPassword(ParameterModel parameterModel, String hostIp, String sessionId) {
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
                    redisService.setKeyAndVal(uauthToken.getToken(), uauthToken);
                    parameterModel.setToken(Base64Utils.encodeBase64String(uauthToken.getToken()));
                    parameterModel.setStatus("201");
                    parameterModel.setLoginType(Base64Utils.encodeBase64String("loginSuccess"));
                    //登录成功
                    return ResponseEntity.ok().body(parameterModel);
                }

            }

        }
        //登录失败
        return ResponseEntity.ok().body(parameterModel);
    }

    /**
     * 检查redis中是否有信息
     * @param token
     * @return
     */
    @Override
    public boolean checkTokenExit(String token) {
        return redisService.checkTokenExit(token);
    }
}

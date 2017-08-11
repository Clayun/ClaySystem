package com.mcylm.clay.securityservice.service.impl;

import com.mcylm.clay.securityservice.dao.UauthDao;
import com.mcylm.clay.securityservice.module.Uauth;
import com.mcylm.clay.securityservice.service.UauthService;
import com.mcylm.clay.securityservice.service.UauthTokenService;
import com.mcylm.clay.securityservice.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static org.bouncycastle.asn1.x500.style.RFC4519Style.uid;

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
     * @param username
     * @param password
     * @return
     */
    @Override
    public ResponseEntity getUuidByUsernameAndPassword(String username, String password, String hostIp, String sessionId) {
        //MD5加密数据
        Uauth uauth = uauthDao.getUuidByUsernameAndPassword(username);

        if (uauth != null && uauth.getUuid() != null && !"".equals(uauth.getUuid())) {

            boolean flag = MD5Util.verify(password, uauth.getPassWord());

            if (flag) {
                //把用户登录信息存入token
                ResponseEntity result = uauthTokenService.insertUauthTokenMessage(uauth.getUuid(), hostIp, sessionId);
                //登录成功
                return result;
            }
            //登录失败
            return ResponseEntity.ok().body(510);
        }
        //登录失败
        return ResponseEntity.ok().body(510);


    }
}

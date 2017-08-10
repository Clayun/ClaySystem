package com.mcylm.clay.securityservice.service.impl;

import com.mcylm.clay.securityservice.dao.UauthTokenDao;
import com.mcylm.clay.securityservice.service.UauthTokenService;
import com.mcylm.clay.securityservice.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Created by lenovo on 2017/8/9.
 * token 业务操作
 */
@Service
public class UauthTokenServiceImpl implements UauthTokenService {

    @Autowired
    private UauthTokenDao uauthTokenDao;

    @Override
    public ResponseEntity insertUauthTokenMessage(String uid, String hostIp, String sessionId) {
        //生成 token
        String token = StringUtils.getUuid();
        //向 token 表中添加数据
        Integer num = uauthTokenDao.insertUauthTokenMessage(uid,hostIp,sessionId,token);

        if (num==1)
            return ResponseEntity.ok().body(201);
        else
            return ResponseEntity.ok().body(510);
    }
}

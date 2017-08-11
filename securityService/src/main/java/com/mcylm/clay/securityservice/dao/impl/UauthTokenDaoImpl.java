package com.mcylm.clay.securityservice.dao.impl;

import com.mcylm.clay.securityservice.dao.UauthTokenDao;
import com.mcylm.clay.securityservice.mapper.UauthTokenMapper;
import com.mcylm.clay.securityservice.module.UauthToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by lenovo on 2017/8/9.
 */
@Repository
public class UauthTokenDaoImpl implements UauthTokenDao {
    @Autowired
    private UauthTokenMapper uauthTokenMapper;


    @Override
    public Integer insertUauthTokenMessage(String uid, String hostIp, String sessionId, String token) {
        return uauthTokenMapper.insertUauthTokenMessage(uid,hostIp,sessionId,token);
    }

    @Override
    public UauthToken findUauthTokenByToken(String token) {
        return uauthTokenMapper.findUauthTokenByToken(token);
    }

}

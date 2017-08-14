package com.mcylm.clay.securityservice.dao;

import com.mcylm.clay.securityservice.module.UauthToken;

/**
 * Created by lenovo on 2017/8/9.
 */
public interface UauthTokenDao {
    Integer insertUauthTokenMessage(String uid, String hostIp, String sessionId, String token);

    UauthToken findUauthTokenByToken(String token);
}

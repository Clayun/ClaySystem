package com.mcylm.clay.securityservice.service;


import com.mcylm.clay.securityservice.module.UauthToken;

/**
 * Created by lenovo on 2017/8/9.
 */
public interface UauthTokenService {

    UauthToken insertUauthTokenMessage(String uid, String hostIp, String sessionId);
}

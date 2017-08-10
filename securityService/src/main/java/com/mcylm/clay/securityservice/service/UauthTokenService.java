package com.mcylm.clay.securityservice.service;


import org.springframework.http.ResponseEntity;

/**
 * Created by lenovo on 2017/8/9.
 */
public interface UauthTokenService {

    ResponseEntity insertUauthTokenMessage(String uid, String hostIp, String sessionId);
}

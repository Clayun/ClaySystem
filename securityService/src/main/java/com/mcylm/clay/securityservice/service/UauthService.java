package com.mcylm.clay.securityservice.service;

import org.springframework.http.ResponseEntity;

/**
 * Created by lenovo on 2017/8/7.
 */
public interface UauthService {
    ResponseEntity getUuidByUsernameAndPassword(String username, String password, String hostIp, String sessionId);
}

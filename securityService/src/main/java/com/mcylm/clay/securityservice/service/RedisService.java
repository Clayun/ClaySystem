package com.mcylm.clay.securityservice.service;

import com.mcylm.clay.securityservice.module.UauthToken;

/**
 * Created by lenovo on 2017/8/10.
 */
public interface RedisService {
    void setKeyAndVal(String token, UauthToken uauthToken);

    boolean checkTokenExit(String token);
}

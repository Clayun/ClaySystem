package com.mcylm.clay.securityservice.service;

import com.mcylm.clay.securityservice.module.ParameterModel;
import org.springframework.http.ResponseEntity;

/**
 * Created by lenovo on 2017/8/7.
 */
public interface UauthService {

    ResponseEntity<ParameterModel> getUuidByUsernameAndPassword(ParameterModel parameterModel, String hostIp, String sessionId);

}

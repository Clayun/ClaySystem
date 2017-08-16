package com.mcylm.clay.securityservice.service.impl;

import com.mcylm.clay.securityservice.dao.UauthTokenDao;
import com.mcylm.clay.securityservice.module.UauthToken;
import com.mcylm.clay.securityservice.service.UauthTokenService;
import com.mcylm.clay.securityservice.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lenovo on 2017/8/9.
 * token 业务操作
 */
@Service
public class UauthTokenServiceImpl implements UauthTokenService {

    @Autowired
    private UauthTokenDao uauthTokenDao;

    /**
     * 生成token 并将数据存入信息表
     * @param uid
     * @param hostIp
     * @param sessionId
     * @return
     */
    @Override
    public UauthToken insertUauthTokenMessage(String uid, String hostIp, String sessionId) {
        //生成 token
        String token = StringUtils.getUuid();
        //向 token 表中添加数据
        Integer num = uauthTokenDao.insertUauthTokenMessage(uid, hostIp, sessionId, token);

        if (num == 1) {
            UauthToken uauthToken = uauthTokenDao.findUauthTokenByToken(token);
            return uauthToken;
        }

        return null;
    }
}

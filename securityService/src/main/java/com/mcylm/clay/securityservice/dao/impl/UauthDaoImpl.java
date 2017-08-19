package com.mcylm.clay.securityservice.dao.impl;

import com.mcylm.clay.securityservice.dao.UauthDao;
import com.mcylm.clay.securityservice.mapper.UauthMapper;
import com.mcylm.clay.securityservice.module.ParameterModel;
import com.mcylm.clay.securityservice.module.Uauth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by lenovo on 2017/8/7.
 */
@Repository
public class UauthDaoImpl implements UauthDao {
    @Autowired
    private UauthMapper uauthMapper;

    /**
     * 登录 获取 uuid
     *
     * @param username
     * @return
     */
    @Override
    public Uauth getUuidByUsernameAndPassword(String username) {
        Uauth uauth = uauthMapper.getUuidByUsernameAndPassword(username);
        return uauth;
    }

    @Override
    public Uauth checkName(ParameterModel parameterModel) {
        return uauthMapper.checkName(parameterModel);
    }

    @Override
    public void updatePassword(String password, String phone) {
        uauthMapper.updatePassword(password, phone);
    }

    @Override
    public Uauth getUauthByUuid(String uuid) {
        return uauthMapper.getUauthByUuid(uuid);
    }

}

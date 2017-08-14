package com.mcylm.clay.service.consoleservice.service.impl;

import com.mcylm.clay.service.consoleservice.model.Uauth;
import com.mcylm.clay.service.consoleservice.service.UauthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mcylm.clay.service.consoleservice.dao.UauthDao;

import java.util.List;
import java.util.Map;

import static com.mcylm.clay.service.consoleservice.utils.MD5Util.generate;

/**
 * Created by macbook on 2017/8/9.
 */
@Service
public class UauthServiceImpl implements UauthService {
    @Autowired
    private UauthDao UauthDao;

    @Override
    public List<Uauth> getlist(Map<String, Object> map) {
        return UauthDao.getlist(map);
    }

    @Override
    public void doUpdateUsername(String username, Integer id) {
        UauthDao.doUpdateUsername(username,id);
    }

    @Override
    public void doUpdateUcenterPhone(String phone, Integer id) {
        UauthDao.doUpdateUcenterPhone(phone,id);
    }

    @Override
    public void doUpdateEmail(String email, Integer id) {
        UauthDao.doUpdateEmail(email,id);
    }

    @Override
    public void doUpdatePassword(String password, Integer id) {
        UauthDao.doUpdatePassword(generate(password),id);
    }

    @Override
    public void uauthadd(Uauth uauth) {
        uauth.setPassword(generate(uauth.getPassword()));
        UauthDao.uauthadd(uauth);
        UauthDao.uauthadd(uauth);
    }

    @Override
    public void doUpdateContent(String content, Integer id) {
        UauthDao.doUpdateContent(content,id);
    }
}

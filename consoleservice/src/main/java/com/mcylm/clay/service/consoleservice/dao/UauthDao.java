package com.mcylm.clay.service.consoleservice.dao;

import com.mcylm.clay.service.consoleservice.model.Page;
import com.mcylm.clay.service.consoleservice.model.Uauth;

import java.util.List;
import java.util.Map;

/**
 * Created by macbook on 2017/8/9.
 */
public interface UauthDao {

    List<Uauth> getList(Page page, Map<String, Object> map);

    List<Uauth> getEmailList(String content);

    List<Uauth> getUserNameList(String content);

    List<Uauth> getPhoneList(String content);

    void doUpdateUsername(String username, Integer id);

    void doUpdateUcenterPhone(String phone, Integer id);

    void doUpdateEmail(String email, Integer id);

    void doUpdatePassword(String password, Integer id);

    void uauthadd(Uauth uauth);

    void doUpdateContent(String content, Integer id);

    int getCount();

    int getEmailCount(String content);

    int getUsernameCount(String content);

    int getPhoneCount(String content);

}

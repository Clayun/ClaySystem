package com.mcylm.clay.service.consoleservice.dao;

import com.mcylm.clay.service.consoleservice.model.Page;
import com.mcylm.clay.service.consoleservice.model.Ucenter;

import java.util.List;
import java.util.Map;

/**
 * Created by Mr_Shen on 2017/8/7/007.
 */
public interface UcenterDao {

    List<Ucenter> getList(Page page,Map<String, Object> map);

    List<Ucenter> getIDList(String content);

    List<Ucenter> getUsernameList(String content);

    List<Ucenter> getPhoneList(String content);

    void ucenteradd(Ucenter ucenter);

    void ucenterdel(Integer id);

    void doUpdateUcenter(String username, Integer id);

    void doUpdateUcenterPhone(String phone, Integer id);

    void doUpdatePassword(String password, Integer id);

    int getCount();

    int getIDCount(String content);

    int getUsernameCount(String content);

    int getPhoneCount(String content);

}
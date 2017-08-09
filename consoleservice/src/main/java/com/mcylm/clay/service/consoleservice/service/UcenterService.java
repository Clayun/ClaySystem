package com.mcylm.clay.service.consoleservice.service;

import com.mcylm.clay.service.consoleservice.model.Ucenter;

import java.util.List;
import java.util.Map;

/**
 * Created by Mr_Shen on 2017/8/7/007.
 */
public interface UcenterService {

    List<Ucenter> getList(Map<String, Object> map);

    void ucenteradd(Ucenter ucenter);

    void ucenterdel(Integer id);

    void doUpdateUcenter(String username, Integer id);

    void doUpdateUcenterPhone(String phone, Integer id);
}
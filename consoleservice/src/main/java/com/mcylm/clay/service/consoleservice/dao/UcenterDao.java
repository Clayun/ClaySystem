package com.mcylm.clay.service.consoleservice.dao;

import com.mcylm.clay.service.consoleservice.model.Ucenter;

import java.util.List;

/**
 * Created by Mr_Shen on 2017/8/7/007.
 */
public interface UcenterDao {

    List<Ucenter> ucenterlist();

    void doUpdateUcenter(String username, Integer id);
}

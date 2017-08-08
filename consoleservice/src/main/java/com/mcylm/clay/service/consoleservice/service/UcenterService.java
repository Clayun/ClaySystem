package com.mcylm.clay.service.consoleservice.service;

import com.mcylm.clay.service.consoleservice.model.Ucenter;

import java.util.List;

/**
 * Created by Mr_Shen on 2017/8/7/007.
 */
public interface UcenterService {

    List<Ucenter> ucenterlist();

  /*  Ucenter toUpdateUcenter(Integer id);*/

    void doUpdateUcenter(String username, Integer id);
}

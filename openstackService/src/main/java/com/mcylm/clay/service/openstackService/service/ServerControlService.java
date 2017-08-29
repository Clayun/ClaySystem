package com.mcylm.clay.service.openstackService.service;

import com.mcylm.clay.service.openstackService.model.ucenter.EcsServer;

import java.util.List;

/**
 * Created by Mikesam on 2017/8/28.
 */
public interface ServerControlService {

    void create();

    void delete();

    EcsServer getServerInfo(String serveruuid);

    List<EcsServer> getServerInfoListByUserUUID(String useruuid);
}

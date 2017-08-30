package com.mcylm.clay.service.openstackService.service.impl;

import com.mcylm.clay.service.openstackService.mapper.EcsMapper;
import com.mcylm.clay.service.openstackService.model.ucenter.EcsServer;
import com.mcylm.clay.service.openstackService.service.ServerControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mikesam on 2017/8/29.
 */
@Service
public class ServerControlServiceImpl implements ServerControlService {

    @Autowired
    private EcsMapper ecsMapper;
    @Override
    public void create() {

    }

    @Override
    public void delete() {

    }

    @Override
    public EcsServer getServerInfo(String serveruuid) {
        return ecsMapper.getEcsServerByUUID(serveruuid);
    }

    @Override
    public List<EcsServer> getServerInfoListByUserUUID(String useruuid) {
        return null;
    }

    @Override
    public boolean checkServerOwnedByUserUUID(String uuid, String serUUid) {
        if(getServerInfo(serUUid).getUuid().equals(uuid))
            return true;
        return false;
    }
}

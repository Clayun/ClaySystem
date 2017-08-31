package com.mcylm.clay.service.openstackService.service.impl;

import com.google.gson.Gson;
import com.mcylm.clay.service.openstackService.mapper.EcsMapper;
import com.mcylm.clay.service.openstackService.model.ucenter.EcsServer;
import com.mcylm.clay.service.openstackService.model.ucenter.ParameterModel;
import com.mcylm.clay.service.openstackService.model.ucenter.UauthToken;
import com.mcylm.clay.service.openstackService.service.ServerControlService;
import com.mcylm.clay.service.openstackService.utils.Base64Utils;
import com.mcylm.clay.service.openstackService.utils.JCloudsNova;
import com.mcylm.clay.service.openstackService.utils.RedisUtils;
import org.jclouds.openstack.nova.v2_0.domain.ServerCreated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
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

    @Override
    public String createInstance(String ser_uuid, HttpServletRequest request, ParameterModel parameterModel,JCloudsNova jCloudsNova) {

        if(parameterModel.getToken() == null || parameterModel.getToken() == ""){
            if(request.getSession().getAttribute("token") != null){
                parameterModel.setToken(String.valueOf(request.getSession().getAttribute("token")));
            }else{
                return "unlogin";
            }
        }
        String recharge = RedisUtils.checkLogin(parameterModel, "instance");
        if(recharge.equals("instance")){
            EcsServer ecsServer = getServerInfo(ser_uuid);
            if(checkServerOwnedByUserUUID(getUUidByToken(parameterModel.getToken()),ser_uuid)){
                ecsMapper.updateEcsServerStateBySerUuid(ser_uuid,4);
                ServerCreated nova = jCloudsNova.createInstance(ecsServer, "nova");
                if(nova.getId() != null){
                    ecsMapper.updateEcsServerStateBySerUuid(ser_uuid,4);
                    return "success";
                }
            }else{
                return "failed";
            }
        }
        return "unlogin";
    }

    private String getUUidByToken(String uuid) {
        String valByKey = RedisUtils.getValByKey(Base64Utils.decodeBase64String(uuid));
        Gson gson = new Gson();
        UauthToken uauthToken = gson.fromJson(valByKey, UauthToken.class);
        return uauthToken.getUuid();
    }
}

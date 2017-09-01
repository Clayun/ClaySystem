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
import java.util.Map;

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
    public List<EcsServer> getServerInfoListByUserUUID(HttpServletRequest request) {
        if(request.getSession().getAttribute("token") != null){
            return ecsMapper.getEcsServersByUserUUID(getUUidByToken(String.valueOf(request.getSession().getAttribute("token"))));
        }
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
                ecsMapper.updateEcsServerStateBySerUuid(ser_uuid,5);
                ServerCreated nova = jCloudsNova.createInstance(ecsServer, "nova");
                if(nova.getId() != null){
                    ecsMapper.updateEcsServerStateBySerUuid(ser_uuid,5);
                    ecsMapper.updateServerUUIDbyName(nova.getId(),ecsServer.getSer_name());
                    return "success";
                }
            }else{
                return "failed";
            }
        }
        return "unlogin";
    }

    @Override
    public String showInstanceById(String name, HttpServletRequest request, ParameterModel parameterModel, Map<String, Object> map) {

        if(parameterModel.getToken() == null || parameterModel.getToken() == ""){
            if(request.getSession().getAttribute("token") != null){
                parameterModel.setToken(String.valueOf(request.getSession().getAttribute("token")));
            }
        }

        System.out.println(parameterModel.getToken());

        EcsServer ecsServer = ecsMapper.getEcsServerByName(name);
        map.put("ecsInfo",ecsServer);
        StringBuffer url = request.getRequestURL();
        url.replace(16, 22, "/ecs/");
        parameterModel.setRedirectUrl(url.toString());
        //检测是否登录
        String recharge = RedisUtils.checkLogin(parameterModel, "instance");
        if(recharge.equals("instance")){
            return recharge;
        }
        return recharge;
    }

    @Override
    public boolean checkServerBelongToUser(String ser_uuid, HttpServletRequest request) {

        String uuid = getUUidByToken(String.valueOf(request.getSession().getAttribute("token")));
        if(ecsMapper.getEcsServerByUUID(ser_uuid).getUuid().equals(uuid)){
            return true;
        }

        return false;
    }

    private String getUUidByToken(String uuid) {
        String valByKey = RedisUtils.getValByKey(Base64Utils.decodeBase64String(uuid));
        Gson gson = new Gson();
        UauthToken uauthToken = gson.fromJson(valByKey, UauthToken.class);
        return uauthToken.getUuid();
    }
}

package com.mcylm.clay.service.openstackService.service;

import com.mcylm.clay.service.openstackService.model.ucenter.EcsServer;
import com.mcylm.clay.service.openstackService.model.ucenter.ParameterModel;
import com.mcylm.clay.service.openstackService.utils.JCloudsNova;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by Mikesam on 2017/8/28.
 */
public interface ServerControlService {

    void create();

    void delete();

    EcsServer getServerInfo(String serveruuid);

    List<EcsServer> getServerInfoListByUserUUID(HttpServletRequest request);

    boolean checkServerOwnedByUserUUID(String uuid,String serUUid);

    String createInstance(String ser_uuid, HttpServletRequest request, ParameterModel parameterModel,JCloudsNova jCloudsNova);

    String showInstanceById(String name,HttpServletRequest request, ParameterModel parameterModel,Map<String,Object> map);

    boolean checkServerBelongToUser(String ser_uuid,HttpServletRequest request);

}

package com.mcylm.clay.service.openstackService.controller;

import com.google.gson.Gson;
import com.mcylm.clay.service.openstackService.mapper.EcsMapper;
import com.mcylm.clay.service.openstackService.model.ecsModel.EcsImageType;
import com.mcylm.clay.service.openstackService.model.ecsModel.EcsProduce;
import com.mcylm.clay.service.openstackService.model.ucenter.EcsServer;
import com.mcylm.clay.service.openstackService.model.ucenter.ParameterModel;
import com.mcylm.clay.service.openstackService.model.ucenter.UauthToken;
import com.mcylm.clay.service.openstackService.service.EcsService;
import com.mcylm.clay.service.openstackService.service.MessageInterfaceService;
import com.mcylm.clay.service.openstackService.service.ServerControlService;
import com.mcylm.clay.service.openstackService.service.impl.ServerControlServiceImpl;
import com.mcylm.clay.service.openstackService.utils.Base64Utils;
import com.mcylm.clay.service.openstackService.utils.JCloudsNova;
import com.mcylm.clay.service.openstackService.utils.RedisUtils;
import org.jclouds.openstack.nova.v2_0.domain.ServerCreated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by Mikesam on 2017/8/9.
 */
@Controller
@RequestMapping("/enterprise")
public class EnterpriseController {

    JCloudsNova jCloudsNova = new JCloudsNova("admin","admin","admin");

    @Autowired
    private EcsService ecsService;

    @Autowired
    private EcsMapper ecsMapper;

    @Autowired
    private ServerControlService serverControlService;

    @RequestMapping("/create")
    public String create(Map<String,Object> map,HttpServletRequest request){
        EcsProduce ecsProduce = ecsService.getEcsProduce();
        map.put("ecsProduce",ecsProduce);
        System.out.println(request.getSession().getId());
        return "create";
    }

    @RequestMapping("/userInfo")
    public String userInfo(){
        return "userInfo";
    }

    @RequestMapping("/message")
    public String message(){
        return "message";
    }

    @RequestMapping("/smsInfo")
    public String smsInfo(){
        return "smsInfo";
    }

    @RequestMapping("/instances")
    public String instances(){
        return "instances";
    }

    @RequestMapping("/instanceList")
    public String instanceList(){
        return "instancelist";
    }

    @RequestMapping("/identify")
    public String identify(){
        return "identify";
    }

    @RequestMapping("/instance")
    public String instance(String ser_uuid,HttpServletRequest request, ParameterModel parameterModel,Map<String,Object> map){

        StringBuffer url = request.getRequestURL();
        url.replace(16, 22, "/ecs/");
        parameterModel.setRedirectUrl(url.toString());
        //检测是否登录
        String recharge = RedisUtils.checkLogin(parameterModel, "instance");
        if(recharge.equals("instance")){
            EcsServer ecsServer = serverControlService.getServerInfo(ser_uuid);
            map.put("ecsInfo",ecsServer);
            return recharge;
        }
        return recharge;
    }

    @RequestMapping("/createInstance")
    @ResponseBody
    public String initInstance(String ser_uuid,HttpServletRequest request, ParameterModel parameterModel){
        //检测是否登录
        String recharge = RedisUtils.checkLogin(parameterModel, "instance");
        if(recharge.equals("instance")){
            EcsServer ecsServer = serverControlService.getServerInfo(ser_uuid);
            if(serverControlService.checkServerOwnedByUserUUID(getUUidByToken(parameterModel.getToken()),ser_uuid)){
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

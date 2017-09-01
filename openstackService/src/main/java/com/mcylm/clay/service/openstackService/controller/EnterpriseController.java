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
import javax.servlet.http.HttpServletResponse;
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
    public String create(Map<String,Object> map){
        EcsProduce ecsProduce = ecsService.getEcsProduce();
        map.put("ecsProduce",ecsProduce);
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
    public String instanceList(HttpServletRequest request,Map<String,Object> map){
        List<EcsServer> list = serverControlService.getServerInfoListByUserUUID(request);
        map.put("list",list);
        if(list == null){
            return "404";
        }
        return "instancelist";
    }

    @RequestMapping("/identify")
    public String identify(){
        return "identify";
    }

    @RequestMapping("/instance")
    public String instance(String ser_uuid,HttpServletRequest request, ParameterModel parameterModel,Map<String,Object> map){
        return serverControlService.showInstanceById(ser_uuid,request,parameterModel,map);
    }

    @RequestMapping("/console")
    public String console(String id,Map<String,Object> map,HttpServletRequest request){
        if(id == null || id == ""){
            return "404";
        }
        boolean belong = serverControlService.checkServerBelongToUser(id,request);
        map.put("url",jCloudsNova.getConsoleUrl(id,request,belong));
        return "console";
    }

    @RequestMapping("/createInstance")
    @ResponseBody
    public String initInstance(String ser_uuid,HttpServletRequest request, ParameterModel parameterModel){
        return serverControlService.createInstance(ser_uuid,request,parameterModel,jCloudsNova);
    }




}

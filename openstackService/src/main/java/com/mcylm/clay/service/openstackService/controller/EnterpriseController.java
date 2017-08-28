package com.mcylm.clay.service.openstackService.controller;

import com.mcylm.clay.service.openstackService.model.ecsModel.EcsImageType;
import com.mcylm.clay.service.openstackService.model.ecsModel.EcsProduce;
import com.mcylm.clay.service.openstackService.service.EcsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by Mikesam on 2017/8/9.
 */
@Controller
@RequestMapping("/enterprise")
public class EnterpriseController {
    @Autowired
    private EcsService ecsService;

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

    @RequestMapping("/identify")
    public String identify(){
        return "identify";
    }

    @RequestMapping("/right")
    public String right(){
        return "right";
    }


}

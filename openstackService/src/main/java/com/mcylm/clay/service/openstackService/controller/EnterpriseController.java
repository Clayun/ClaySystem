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



}

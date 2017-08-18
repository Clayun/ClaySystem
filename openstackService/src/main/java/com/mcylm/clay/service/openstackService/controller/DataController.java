package com.mcylm.clay.service.openstackService.controller;

import com.google.gson.Gson;
import com.mcylm.clay.service.openstackService.model.ecsModel.EcsImageName;
import com.mcylm.clay.service.openstackService.model.ecsModel.EcsImageType;
import com.mcylm.clay.service.openstackService.service.EcsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Mikesam on 2017/8/15.
 */
@Controller
@RequestMapping("/data")
public class DataController {

    private Gson gson = new Gson();

    @Autowired
    private EcsService ecsService;

    @RequestMapping("/getOsType")
    @ResponseBody
    public String getOsType(){
        List<EcsImageType> list = ecsService.getEcsImageTypeList();
        String json = gson.toJson(list);
        return json;
    }

    @RequestMapping("/getOsName")
    @ResponseBody
    public String getOsName(int typeId){
        List<EcsImageName> list = ecsService.getEcsImageNameList(typeId);
        String json = gson.toJson(list);
        return json;
    }

    @RequestMapping(value = "/getEcsPrice" , method = RequestMethod.POST)
    @ResponseBody
    public double getEcsPrice(String Ecspz){
        return ecsService.getEcsPrice(Ecspz);
    }

    @RequestMapping(value = "/createEcsOrder" , method = RequestMethod.POST)
    @ResponseBody
    public String createEcsOrder(String ecspz,String image,String pwd){
        return ecsService.toJsonEcsOrder(ecspz,image,pwd);
    }
}

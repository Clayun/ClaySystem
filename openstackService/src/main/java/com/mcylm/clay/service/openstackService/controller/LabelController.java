package com.mcylm.clay.service.openstackService.controller;

import com.mcylm.clay.service.openstackService.model.label.Label;
import com.mcylm.clay.service.openstackService.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @Author:Mr_Shen
 * @Description: 查询标签数据
 * @Date:2017/8/16/016
 * @Modified By:None one
 */

@Controller
@RequestMapping("/label")
public class LabelController {

    @Autowired
    private LabelService labelService;

    @RequestMapping("/labellist")
    public String Labellist(Map<String,Object> map){
        Label label=labelService.getLabel();
        map.put("label",label);
        return "index";
    }

    @RequestMapping("/userInfo")
    public String userInfo(Map<String,Object> map){
        Label label=labelService.getLabel();
        map.put("label",label);
        return "userInfo";
    }

    @RequestMapping("/message")
    public String message(Map<String,Object> map){
        Label label=labelService.getLabel();
        map.put("label",label);
        return "message";
    }

    @RequestMapping("/smsInfo")
    public String smsInfo(Map<String,Object> map){
        Label label=labelService.getLabel();
        map.put("label",label);
        return "smsInfo";
    }

    @RequestMapping("/identify")
    public String identify(Map<String,Object> map){
        Label label=labelService.getLabel();
        map.put("label",label);
        return "identify";
    }

    @RequestMapping("/right")
    public String right(Map<String,Object> map){
        Label label=labelService.getLabel();
        map.put("label",label);
        return "right";
    }
}
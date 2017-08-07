package com.mcylm.clay.service.normalservice.controller;

import com.google.gson.Gson;
import com.mcylm.clay.service.normalservice.model.Label;
import com.mcylm.clay.service.normalservice.service.InterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Mikesam on 2017/8/5.
 */
@Controller
@RequestMapping("/")
public class PortalController {

    @Autowired
    private InterfaceService interfaceService;

    @RequestMapping(value = {"/","/index"})
    public String portal(Map<String,Object> map) throws IOException {
        List<Label> index = interfaceService.selectLabelsByPage("index");
        for(Label label : index){
            map.put(label.getKey(),label);
        }
        List<Label> normal = interfaceService.selectLabelsByPage("normal");
        for(Label label : normal){
            map.put(label.getKey(),label);
        }
        return "index";
    }
}

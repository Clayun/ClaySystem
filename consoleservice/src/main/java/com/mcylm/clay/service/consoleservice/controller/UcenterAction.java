package com.mcylm.clay.service.consoleservice.controller;

import com.mcylm.clay.service.consoleservice.model.Ucenter;
import com.mcylm.clay.service.consoleservice.service.UcenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Mr_Shen on 2017/8/7/007.
 */
@Controller
@RequestMapping("/list")
public class UcenterAction {

    @Autowired
    private UcenterService ucenterService;

    @RequestMapping("/ucenterlist")
    public String ucenterlist(Map<String,Object> map) throws IOException {
      List<Ucenter>list = ucenterService.ucenterlist();
        map.put("list",list);
        return "console";
    }

    @RequestMapping("doUpdateUcenter")
    public String toUpdateUcenter(String username){
//       ucenterService.toUpdateUcenter(id);
//          map.put("u",u);
        return "updateUcenter";
    }
}
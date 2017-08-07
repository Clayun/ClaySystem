package com.mcylm.clay.consoleservice.controller;

import com.mcylm.clay.consoleservice.service.UcenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Mr_Shen on 2017/8/7/007.
 */
@Controller
public class UcenterAction {

    @Autowired
    private UcenterService ucenterService;

    @RequestMapping("/ucenterlist")
    public String ucenterlist(){

        return "列表";
    }
}

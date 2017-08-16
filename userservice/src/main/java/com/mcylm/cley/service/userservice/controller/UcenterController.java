package com.mcylm.cley.service.userservice.controller;

import com.mcylm.cley.service.userservice.entity.UcenterD;
import com.mcylm.cley.service.userservice.service.UCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ucenter")
public class UcenterController {

    @Autowired
    private UCenterService userService;

    @RequestMapping("/ucenterList")
    public String list(Map<String,Object> map) {
        List<UcenterD> list = userService.getUserList();
//        request.setAttribute("list",list);
        map.put("list",list);
        return "index";
//        return ResponseEntity.status(HttpStatus.OK).body(list);
    }


    @RequestMapping("/update")
    public String update(UcenterD user) {
        UcenterD us = userService.updateUser(user);
        return "update";
    }
}

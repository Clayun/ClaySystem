package com.mcylm.clay.service.openstackService.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * @Author:Mr_Shen
 * @Description: 查询标签数据
 * @Date:2017/8/16/016
 * @Modified By:None one
 */

@Controller
@RequestMapping("/label")
public class LabelController {

    @RequestMapping("/labellist")
    public String Labellist(){
        return "index";
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
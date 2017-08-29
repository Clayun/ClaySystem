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
}
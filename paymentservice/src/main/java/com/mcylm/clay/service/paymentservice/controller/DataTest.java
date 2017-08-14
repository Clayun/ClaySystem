package com.mcylm.clay.service.paymentservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lenovo-pc on 2017/8/14.
 */
@Controller
public class DataTest {
    /**
     * 测试
     * @return
     */
    @RequestMapping(value = "/index")
    private String withdrawalInterface() {
        return "index";
    }

}

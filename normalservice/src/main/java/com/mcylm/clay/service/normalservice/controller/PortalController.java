package com.mcylm.clay.service.normalservice.controller;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Mikesam on 2017/8/5.
 */
@RestController
@RequestMapping("/index")
public class PortalController {

    @RequestMapping("/index")
    public String getLabelById() throws IOException {
        return "index";
    }
}

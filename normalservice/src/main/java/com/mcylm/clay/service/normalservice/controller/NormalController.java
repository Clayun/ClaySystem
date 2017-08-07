package com.mcylm.clay.service.normalservice.controller;

import com.google.gson.Gson;
import com.mcylm.clay.service.normalservice.service.InterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Mikesam on 2017/8/4.
 */
@RestController
@RequestMapping("/static")
public class NormalController {

    @Autowired
    private InterfaceService interfaceService;

    @RequestMapping("/labels")
    public void getLabelById(HttpServletResponse response,String id) throws IOException {
        Gson gson = new Gson();
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(gson.toJson(interfaceService.selectLabelByKey(id)));
    }

}

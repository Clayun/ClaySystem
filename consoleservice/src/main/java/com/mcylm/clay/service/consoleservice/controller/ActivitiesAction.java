package com.mcylm.clay.service.consoleservice.controller;

import com.mcylm.clay.service.consoleservice.model.Activities;
import com.mcylm.clay.service.consoleservice.model.ActivitiesStr;
import com.mcylm.clay.service.consoleservice.service.ActivitiesService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by macbook on 2017/8/11.
 */
@Controller
@RequestMapping("/activities")
public class ActivitiesAction {
    @Autowired
    private ActivitiesService activitiesService;

    @RequestMapping("activitieslist")
    public String list(Map<String, Object> map) {
        List<Activities> list = activitiesService.activitieslist();
        map.put("list", list);
        return "activities";
    }

    @RequestMapping(value = "/activitiesAdd", method = RequestMethod.POST)
    @ResponseBody
    public Boolean activitiesAdd(ActivitiesStr activities) {
        try {
            System.out.println(activities.toString());

            activitiesService.activitiesAdd(activities);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    @RequestMapping(value = "/activitiesUpdate", method = RequestMethod.POST)
    public String activitiesUpdate(ActivitiesStr activities) {
            activitiesService.activitiesUpdate(activities);
            return "";
    }
}

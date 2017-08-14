package com.mcylm.clay.service.consoleservice.controller;

import com.mcylm.clay.service.consoleservice.model.Activities;
import com.mcylm.clay.service.consoleservice.model.ActivitiesStr;
import com.mcylm.clay.service.consoleservice.service.ActivitiesService;
import com.mcylm.clay.service.consoleservice.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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
    public String activitieslist(String dropdownbox, String pageNo, String content, HttpServletRequest request, Map<String, Object> map) {
        pageNo=request.getParameter("cPage")==null?"1":request.getParameter("cPage");
        int pageSize=8;
        int listCount = activitiesService.getCount(dropdownbox,content);
        if (listCount == 0){
            pageNo = "0";
        }
        if(content!=null){
            pageNo="0";
            listCount=0;
        }
        List<Activities> list = activitiesService.activitieslist(dropdownbox,content,Integer.parseInt(pageNo),pageSize,map);
        map.put("list",list);
        request.setAttribute("dropdownbox",dropdownbox);
        request.setAttribute("content",content);
        PageUtil.page(request, Integer.parseInt(pageNo), pageSize, listCount, map, list);
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

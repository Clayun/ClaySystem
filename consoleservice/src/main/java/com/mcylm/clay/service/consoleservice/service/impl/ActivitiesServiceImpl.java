package com.mcylm.clay.service.consoleservice.service.impl;

import com.mcylm.clay.service.consoleservice.dao.ActivitiesDao;
import com.mcylm.clay.service.consoleservice.model.Activities;
import com.mcylm.clay.service.consoleservice.model.ActivitiesStr;
import com.mcylm.clay.service.consoleservice.model.Page;
import com.mcylm.clay.service.consoleservice.model.Ucenter;
import com.mcylm.clay.service.consoleservice.service.ActivitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by macbook on 2017/8/11.
 */
@Service
public class ActivitiesServiceImpl  implements ActivitiesService {
    @Autowired
    private ActivitiesDao activitiesDao;

 /*   @Override
    public List<Activities> activitieslist() {
        return activitiesDao.activitieslist();
    }*/

    @Override
    public List<Activities> activitieslist(String dropdownbox, String content, Integer pageNo, Integer pageSize, Map<String, Object> map) {
        List<Activities> list;
        content="%" + content + "%";
        if(dropdownbox==null){
            Page page=new Page();
            int cPage=(pageNo - 1)*pageSize;
            page.setcPage(cPage);
            page.setPageSize(pageSize);
            list=activitiesDao.activitieslist(page,map);
        }else if(dropdownbox.contains("活动标题")){
            list=activitiesDao.activitieslistTitle(content);
        }else if(dropdownbox.contains("活动状态")){
            list=activitiesDao.activitieslistState(content);
        }else{
            list=activitiesDao.activitieslistmanagerName(content);
        }
        return list;
    }

    @Override
    public void activitiesAdd(ActivitiesStr activities) {
        activitiesDao.activitiesAdd(activities);
    }

    @Override
    public Activities toUpdateActivities(Integer id) {
        return activitiesDao.toUpdateActivities(id);
    }

    @Override
    public void activitiesUpdate(ActivitiesStr activities) {
        activitiesDao.activitiesUpdate(activities);
    }

    @Override
    public int getCount(String dropdownbox, String content) {
        int listCount;
        content="%" + content + "%";
        if(dropdownbox==null){
            listCount=activitiesDao.getCount();
        }else if(dropdownbox.contains("活动标题")){
            listCount=activitiesDao.getCountTitle(content);
        }else if(dropdownbox.contains("活动状态")){
            listCount=activitiesDao.getCountState(content);
        }else{
            listCount=activitiesDao.getCountmanagerName(content);
        }
        return  listCount;
    }
}

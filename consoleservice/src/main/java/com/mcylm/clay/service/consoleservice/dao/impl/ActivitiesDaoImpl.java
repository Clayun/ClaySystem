package com.mcylm.clay.service.consoleservice.dao.impl;

import com.mcylm.clay.service.consoleservice.dao.ActivitiesDao;
import com.mcylm.clay.service.consoleservice.mapper.ActivitiesMapper;
import com.mcylm.clay.service.consoleservice.model.Activities;
import com.mcylm.clay.service.consoleservice.model.ActivitiesStr;
import com.mcylm.clay.service.consoleservice.model.Page;
import com.mcylm.clay.service.consoleservice.model.Ucenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by macbook on 2017/8/11.
 */
@Repository
public class ActivitiesDaoImpl implements ActivitiesDao {

    @Autowired
    private ActivitiesMapper activitiesMapper;


   /* @Override
    public List<Activities> activitieslist() {
        return activitiesMapper.activitieslist();
    }
*/
    @Override
    public void activitiesAdd(ActivitiesStr activities) {
        activitiesMapper.activitiesAdd(activities);
    }

    @Override
    public Activities toUpdateActivities(Integer id) {
        return activitiesMapper.toUpdateActivities(id);
    }

    @Override
    public void activitiesUpdate(ActivitiesStr activities) {
        activitiesMapper.activitiesUpdate(activities);
    }

    @Override
    public int getCount() {
        int listCount = activitiesMapper.getCount();
        return listCount;
    }
    @Override
    public int getCountTitle(String content) {
        int listCount = activitiesMapper.getCountTitle(content);
        return listCount;
    }

    @Override
    public int getCountState(String content) {
        int listCount = activitiesMapper.getCountState(content);
        return listCount;
    }

    @Override
    public int getCountmanagerName(String content) {
        int listCount = activitiesMapper.getCountmanagerName(content);
        return listCount;
    }

    @Override
    public List<Activities> activitieslist(Page page, Map<String, Object> map) {
        List<Activities> list = activitiesMapper.activitieslist(page,map);
        return list;
    }

    @Override
    public List<Activities> activitieslistTitle(String content) {
        List<Activities> list = activitiesMapper.activitieslistTitle(content);
        return list;
    }

    @Override
    public List<Activities> activitieslistState(String content) {
        List<Activities> list = activitiesMapper.activitieslistState(content);
        return list;
    }

    @Override
    public List<Activities> activitieslistmanagerName(String content) {
        List<Activities> list = activitiesMapper.activitieslistmanagerName(content);
        return list;
    }

}

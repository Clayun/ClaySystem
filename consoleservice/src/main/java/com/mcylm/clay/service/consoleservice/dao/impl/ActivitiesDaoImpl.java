package com.mcylm.clay.service.consoleservice.dao.impl;

import com.mcylm.clay.service.consoleservice.dao.ActivitiesDao;
import com.mcylm.clay.service.consoleservice.mapper.ActivitiesMapper;
import com.mcylm.clay.service.consoleservice.model.Activities;
import com.mcylm.clay.service.consoleservice.model.ActivitiesStr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by macbook on 2017/8/11.
 */
@Repository
public class ActivitiesDaoImpl implements ActivitiesDao {
    @Autowired
    private ActivitiesMapper activitiesMapper;


    @Override
    public List<Activities> activitieslist() {
        return activitiesMapper.activitieslist();
    }

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
}

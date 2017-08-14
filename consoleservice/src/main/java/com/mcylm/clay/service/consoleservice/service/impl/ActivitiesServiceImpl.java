package com.mcylm.clay.service.consoleservice.service.impl;

import com.mcylm.clay.service.consoleservice.dao.ActivitiesDao;
import com.mcylm.clay.service.consoleservice.model.Activities;
import com.mcylm.clay.service.consoleservice.model.ActivitiesStr;
import com.mcylm.clay.service.consoleservice.service.ActivitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by macbook on 2017/8/11.
 */
@Service
public class ActivitiesServiceImpl  implements ActivitiesService {
    @Autowired
    private ActivitiesDao activitiesDao;

    @Override
    public List<Activities> activitieslist() {
        return activitiesDao.activitieslist();
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
}

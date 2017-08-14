package com.mcylm.clay.service.consoleservice.dao;

import com.mcylm.clay.service.consoleservice.model.Activities;
import com.mcylm.clay.service.consoleservice.model.ActivitiesStr;

import java.util.List;

/**
 * Created by macbook on 2017/8/11.
 */
public interface ActivitiesDao {

    List<Activities> activitieslist();

    void activitiesAdd(ActivitiesStr activities);

    Activities toUpdateActivities(Integer id);

    void activitiesUpdate(ActivitiesStr activities);
}
